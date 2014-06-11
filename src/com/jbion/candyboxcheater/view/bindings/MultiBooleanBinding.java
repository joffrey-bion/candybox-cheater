package com.jbion.candyboxcheater.view.bindings;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import com.jbion.candyboxcheater.game.GameState;
import com.jbion.candyboxcheater.game.Key;

public class MultiBooleanBinding {

	private final LongProperty numberProperty;
	private final BooleanProperty[] booleanProperties;

	public static MultiBooleanBinding createMultiBooleanBinding(GameState state, LongProperty numberProperty, Key... booleanKeys) {
		BooleanProperty[] booleanProperties = new BooleanProperty[booleanKeys.length];
		for (int i = 0; i < booleanProperties.length; i++) {
			booleanProperties[i] = state.getBooleanVariable(booleanKeys[i]).boolValueProperty();
		}
		return new MultiBooleanBinding(numberProperty, booleanProperties);
	}

	public MultiBooleanBinding(LongProperty numberProperty, BooleanProperty... booleanProps) {
		this.numberProperty = numberProperty;
		this.booleanProperties = booleanProps;
		updateNumber();
		numberProperty.addListener(new MultiBooleanNumberChangeListener(this));
		for (int i = 0; i < booleanProperties.length; i++) {
			booleanProperties[i].addListener(new NumberedBooleanChangeListener(this));
		}
	}

	void updateNumber() {
		int i = 0;
		while (i < booleanProperties.length && booleanProperties[i].get()) {
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
					binding.updateNumber();
				} finally {
					changing = false;
				}
			}
		}
	}
}
