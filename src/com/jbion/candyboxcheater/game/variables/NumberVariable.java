package com.jbion.candyboxcheater.game.variables;

import javafx.beans.binding.Bindings;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.converter.NumberStringConverter;

public class NumberVariable extends Variable {

    private LongProperty longValue;
    private StringProperty displayValue;

    public NumberVariable(String name, String value) {
        super(TYPE_NUMBER, name, value);
        longValue = new SimpleLongProperty(Long.parseLong(value));
        displayValue = new SimpleStringProperty();
        Bindings.bindBidirectional(stringValueProperty(), longValue, new NumberStringConverter() {
        	@Override
        	public String toString(Number n) {
        		// no formatting at all, for string variable value
        		return String.valueOf(n);
        	}
        });
        // with formatting for display
        Bindings.bindBidirectional(displayValue, longValue, new NumberStringConverter());
    }

    public LongProperty longValueProperty() {
        return longValue;
    }
    
    public void setLongValue(long value) {
        longValue.set(value);
    }
    
    public long getLongValue() {
        return longValue.get();
    }
    
    /**
     * Increments this {@link NumberVariable} of the specified amount.
     * 
     * @param amount
     *            The new value to set.
     * @return The new value of this variable.
     */
    public long increment(long amount) {
    	long oldValue = getLongValue();
    	boolean overflow = oldValue > Long.MAX_VALUE - amount;
        long newValue = overflow ? Long.MAX_VALUE : oldValue + amount;
        setLongValue(newValue);
        return newValue;
    }
    
    @Override
    public StringProperty displayValueProperty() {
    	return displayValue;
    }
}
