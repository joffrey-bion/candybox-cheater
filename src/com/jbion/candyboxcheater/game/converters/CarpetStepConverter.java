package com.jbion.candyboxcheater.game.converters;

import java.util.Collection;
import java.util.LinkedHashMap;

import javafx.util.StringConverter;

public class CarpetStepConverter extends StringConverter<Number> {

    private static final LinkedHashMap<Number, String> CODES_TO_NAMES = new LinkedHashMap<>();
    private static final LinkedHashMap<String, Number> NAMES_TO_CODES = new LinkedHashMap<>();

    static {
        put(0, "Nothing done");
        put(1, "Lollipop unveiled");
        put(2, "Lollipop picked up");
    }

    private static void put(Number code, String name) {
        CODES_TO_NAMES.put(code, name);
        NAMES_TO_CODES.put(name, code);
    }

    public static Collection<String> getNames() {
        return CODES_TO_NAMES.values();
    }

    @Override
    public String toString(Number code) {
        return CODES_TO_NAMES.get(code.longValue());
    }

    @Override
    public Number fromString(String string) {
        Number mapping = NAMES_TO_CODES.get(string);
        return mapping == null ? null : mapping.longValue();
    }
    
}
