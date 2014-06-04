package com.jbion.candyboxcheater.game.variables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import com.jbion.candyboxcheater.game.Key;

public class Variable {

    static final String TYPE_BOOL = "bool";
    static final String TYPE_STRING = "string";
    static final String TYPE_NUMBER = "number";

    private String type;
    private String name;

    private StringProperty stringValue;

    protected Variable(String type, String name, String value) {
        super();
        this.type = type;
        this.name = name;
        this.stringValue = new SimpleStringProperty(value);
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

    public Key getKey() {
        return Key.valueOf(name);
    }

    public StringProperty stringValueProperty() {
        return stringValue;
    }

    public void setStringValue(String value) {
        this.stringValue.set(value);
    }

    public String getStringValue() {
        return stringValue.get();
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
        this.stringValue.set(var.getStringValue());
    }

    @Override
    public String toString() {
        return type + ' ' + name + '=' + stringValue.get();
    }
}
