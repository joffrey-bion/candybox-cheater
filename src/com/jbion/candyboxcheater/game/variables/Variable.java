package com.jbion.candyboxcheater.game.variables;

import com.jbion.candyboxcheater.game.GameKey;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValueBase;

public class Variable {

    static final String TYPE_BOOL = "bool";
    static final String TYPE_STRING = "string";
    static final String TYPE_NUMBER = "number";

    private String type;
    private String name;

    private StringProperty strValue;

    protected Variable(String type, String name, String value) {
        super();
        this.type = type;
        this.name = name;
        this.strValue = new SimpleStringProperty(value);
    }

    public static Variable create(String type, String name, String value) {
        switch (type) {
        case TYPE_BOOL:
            return new BooleanVariable(name, value);
        case TYPE_NUMBER:
            return new NumberVariable(name, value);
        case TYPE_STRING:
            return new Variable(TYPE_STRING, name, value);
        default:
            throw new IllegalArgumentException("Unknown type '" + type + "'");
        }
    }

    public String getType() {
        return type;
    }

    public GameKey getKey() {
        return GameKey.valueOf(name);
    }

    public StringProperty stringValueProperty() {
        return strValue;
    }

    public void set(String value) {
        this.strValue.set(value);
    }

    public String getAsString() {
        return strValue.get();
    }

    public void updateTo(Variable var) {
        if (!name.equals(var.name)) {
            throw new IllegalArgumentException("Cannot clone variable '" + var.name + "' into this variable named '"
                    + name + "'");
        }
        if (!type.equals(var.type)) {
            throw new IllegalArgumentException("This " + type + " variable '" + name + "', cannot take the given "
                    + var.type + " value");
        }
        this.strValue.set(var.getAsString());
    }

    @Override
    public String toString() {
        return type + ' ' + name + '=' + strValue.get();
    }
}
