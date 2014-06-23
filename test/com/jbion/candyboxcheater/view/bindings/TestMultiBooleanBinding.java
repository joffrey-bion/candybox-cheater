package com.jbion.candyboxcheater.view.bindings;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;

import org.junit.Test;

import com.jbion.candyboxcheater.bindings.MultiBooleanBinding;

public class TestMultiBooleanBinding {

	@Test
	public void testBinding() {
		LongProperty intProp = new SimpleLongProperty(0);
		BooleanProperty[] boolProps = new BooleanProperty[5];
		for (int i = 0; i < boolProps.length; i++) {
			boolProps[i] = new SimpleBooleanProperty(false);
		}
		new MultiBooleanBinding(intProp, boolProps);
		print(intProp, boolProps);
		for (int i = 0; i < boolProps.length; i++) {
			testSetInt(intProp, boolProps, i);
		}
		for (int i = boolProps.length; i >= 0; i--) {
			testSetInt(intProp, boolProps, i);
		}
		
		testSetBool(intProp, boolProps, 0, true);
		testSetBool(intProp, boolProps, 1, true);
		testSetBool(intProp, boolProps, 2, true);
		testSetBool(intProp, boolProps, 3, true);
		testSetBool(intProp, boolProps, 1, false);
	}
	
	private static void testSetInt(LongProperty intProp, BooleanProperty[] boolProps, int i) {
		System.out.print("Setting int to " + i + " \t");
		intProp.set(i);
		print(intProp, boolProps);
	}
	
	private static void testSetBool(LongProperty intProp, BooleanProperty[] boolProps, int i, boolean value) {
		System.out.print("Setting bool[" + i + "] to " + value + " \t");
		boolProps[i].set(value);
		print(intProp, boolProps);
	}

	private static void print(LongProperty intProp, BooleanProperty[] boolProps) {
		System.out.print(intProp.get() + " - ");
		for (BooleanProperty prop : boolProps) {
			System.out.print(prop.get() + " ");
		}
		System.out.println();
	}

}
