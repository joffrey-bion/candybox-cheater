package com.jbion.candyboxcheater.game.variables;

import com.jbion.candyboxcheater.game.GameKey;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

public class NumberVariable extends Variable {

    private LongProperty longValue;

    public NumberVariable(String name, String value) {
        super(TYPE_NUMBER, name, value);
        longValue = new SimpleLongProperty(Long.parseLong(value));
    }

    public LongProperty longValueProperty() {
        return longValue;
    }
    
    public void set(long value) {
        set(String.valueOf(value));
        longValue.set(value);
    }
    
    public long getAsLong() {
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
        long newValue = getAsLong() + amount;
        set(newValue);
        return newValue;
    }
}
