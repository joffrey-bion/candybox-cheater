package com.jbion.candyboxcheater.game.variables;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class BooleanVariable extends Variable {

    private BooleanProperty boolValue;

    public BooleanVariable(String name, String value) {
        super(TYPE_BOOL, name, value);
        boolValue = new SimpleBooleanProperty(Boolean.parseBoolean(value));
        stringValueProperty().bind(Bindings.convert(boolValue));
    }

    public BooleanProperty boolValueProperty() {
        return boolValue;
    }
    
    public void set(boolean value) {
        boolValue.set(value);
    }
    
    public boolean getAsBoolean() {
        return boolValue.get();
    }
}
