package com.jbion.candyboxcheater.view.bindings;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;

import org.junit.Test;

import com.jbion.candyboxcheater.bindings.MultiBooleanBinding;

import static org.junit.Assert.*;

public class TestMultiBooleanBinding {

	@Test
	public void testBinding() {
		LongProperty intProp = new SimpleLongProperty(0);
		BooleanProperty[] boolProps = new BooleanProperty[5];
		for (int i = 0; i < boolProps.length; i++) {
			boolProps[i] = new SimpleBooleanProperty(false);
		}
		MultiBooleanBinding.bind(intProp, boolProps);
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
		testSetBool(intProp, boolProps, 3, false);
		testSetBool(intProp, boolProps, 4, true);
		testSetBool(intProp, boolProps, 2, false);
		testSetBool(intProp, boolProps, 0, false);
	}

	private static void testSetInt(LongProperty intProp, BooleanProperty[] boolProps, int value) {
		System.out.print("Setting int to " + value + " \t");
		intProp.set(value);
		print(intProp, boolProps);
		for (int i = 0; i < boolProps.length; i++) {
			assertEquals(boolProps[i].get(), i < value);
		}
		assertEquals(intProp.get(), value);
	}

	private static void testSetBool(LongProperty intProp, BooleanProperty[] boolProps, int index, boolean value) {
		System.out.print("Setting bool[" + index + "] to " + value + " \t");
		boolProps[index].set(value);
		print(intProp, boolProps);
		if (value) {
			assertEquals(intProp.get(), index + 1);
		}
		for (int i = 0; i < boolProps.length; i++) {
			assertEquals(boolProps[i].get(), i < intProp.get());
		}
	}

	private static void print(LongProperty intProp, BooleanProperty[] boolProps) {
		System.out.print(intProp.get() + " - ");
		for (BooleanProperty prop : boolProps) {
			System.out.print(prop.get() + " ");
		}
		System.out.println();
	}

}
