package com.jbion.candyboxcheater.game.converters;

import java.util.Collection;
import java.util.LinkedHashMap;

import javafx.util.StringConverter;

public class StatusBarCornerStepConverter extends StringConverter<Number> {

    private static final LinkedHashMap<Number, String> CODES_TO_NAMES = new LinkedHashMap<>();
    private static final LinkedHashMap<String, Number> NAMES_TO_CODES = new LinkedHashMap<>();

    static {
        put(0, "+ + + +");
        put(1, "* * * *");
        put(2, "# # # #");
        put(3, "- - - -");
        put(4, "A B C D");
        put(5, "0 1 2 3");
        put(6, "@ @ @ @");
    }

    private static void put(Number code, String name) {
        CODES_TO_NAMES.put(code.intValue(), name);
        NAMES_TO_CODES.put(name, code.intValue());
    }

    public static Collection<String> getNames() {
        return CODES_TO_NAMES.values();
    }

    @Override
    public String toString(Number code) {
        return CODES_TO_NAMES.get(code.intValue());
    }

    @Override
    public Number fromString(String string) {
        Number mapping = NAMES_TO_CODES.get(string);
        return mapping == null ? null : mapping.intValue();
    }
}