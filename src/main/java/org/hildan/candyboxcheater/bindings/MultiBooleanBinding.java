package org.hildan.candyboxcheater.bindings;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Allows to bind a list of booleans to a numeric value. The numeric value represent
 * how many consecutive booleans are {@code true} at the beginning of the list. The
 * only valid states are states where all {@code true} booleans are at the beginning
 * of the list.
 * <p>
 * The following properties are always guaranteed:
 * </p>
 * <ul>
 * <li>If a boolean is {@code true}, then all preceding booleans in the list are
 * {@code true} too.</li>
 * <li>If a boolean is {@code false}, then all following booleans in the list are
 * {@code false} too.</li>
 * <li>The numeric value is always equal to the number of {@code true} booleans.</li>
 * </ul>
 */
public class MultiBooleanBinding {

	private final LongProperty numberProperty;
	private final BooleanProperty[] booleanProperties;

	public static MultiBooleanBinding bind(LongProperty numberProperty, BooleanProperty... booleanProps) {
		return new MultiBooleanBinding(numberProperty, booleanProps);
	}

	public MultiBooleanBinding(LongProperty numberProperty, BooleanProperty... booleanProps) {
		this.numberProperty = numberProperty;
		this.booleanProperties = booleanProps;
		updateNumber(false);
		numberProperty.addListener(new MultiBooleanNumberChangeListener(this));
		for (int i = 0; i < booleanProperties.length; i++) {
			booleanProperties[i].addListener(new NumberedBooleanChangeListener(this));
		}
	}

	void updateNumber(boolean backwards) {
		int i = backwards ? booleanProperties.length : 0;
		if (backwards) {
			while (i > 1 && !booleanProperties[i - 1].get())
				i--;
		} else {
			while (i < booleanProperties.length && booleanProperties[i].get())
				i++;
		}
		numberProperty.set(i);
	}

	void updateBooleans() {
		int value = (int) numberProperty.get();
		for (int i = 0; i < booleanProperties.length; i++) {
			booleanProperties[i].set(i < value);
		}
	}

	private static class MultiBooleanNumberChangeListener implements ChangeListener<Number> {

		private final MultiBooleanBinding binding;
		private boolean changing;

		public MultiBooleanNumberChangeListener(MultiBooleanBinding binding) {
			this.binding = binding;
			this.changing = false;
		}

		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			if (!changing) {
				try {
					changing = true;
					binding.updateBooleans();
				} finally {
					changing = false;
				}
			}
		}
	}

	private static class NumberedBooleanChangeListener implements ChangeListener<Boolean> {

		private final MultiBooleanBinding binding;
		private boolean changing;

		public NumberedBooleanChangeListener(MultiBooleanBinding binding) {
			this.binding = binding;
			this.changing = false;
		}

		@Override
		public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
			if (!changing) {
				try {
					changing = true;
					binding.updateNumber(newValue);
				} finally {
					changing = false;
				}
			}
		}
	}
}
