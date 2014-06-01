package com.jbion.candyboxcheater.game.variables;

import javafx.beans.binding.Bindings;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.util.converter.NumberStringConverter;

public class NumberVariable extends Variable {

    private LongProperty longValue;

    public NumberVariable(String name, String value) {
        super(TYPE_NUMBER, name, value);
        longValue = new SimpleLongProperty(Long.parseLong(value));
        Bindings.bindBidirectional(stringValueProperty(), longValue, new NumberStringConverter());
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
        long newValue = getLongValue() + amount;
        setLongValue(newValue);
        return newValue;
    }
}
