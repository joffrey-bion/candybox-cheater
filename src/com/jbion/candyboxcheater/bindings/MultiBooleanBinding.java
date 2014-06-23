package com.jbion.candyboxcheater.bindings;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

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
