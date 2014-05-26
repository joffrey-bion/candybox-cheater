package com.jbion.candyboxcheater.game.converters;

import java.util.Collection;
import java.util.LinkedHashMap;

import javafx.util.StringConverter;

public class LanguageConverter extends StringConverter<String> {

    private static final LinkedHashMap<String, String> CODES_TO_NAMES = new LinkedHashMap<>();
    private static final LinkedHashMap<String, String> NAMES_TO_CODES = new LinkedHashMap<>();

    static {
        put("en", "English");
        put("br", "Brazilian portuguese");
        put("zh", "Chinese");
        put("cz", "Czech");
        put("nl", "Dutch");
        put("fr", "French");
        put("de", "German");
        put("hu", "Hungarian");
        put("id", "Indonesian");
        put("pl", "Polish");
        put("se", "Swedish");
    }

    private static void put(String langCode, String langName) {
        CODES_TO_NAMES.put(langCode, langName);
        NAMES_TO_CODES.put(langName, langCode);
    }

    public static Collection<String> getNames() {
        return CODES_TO_NAMES.values();
    }

    @Override
    public String toString(String langCode) {
        return CODES_TO_NAMES.get(langCode);
    }

    @Override
    public String fromString(String langName) {
        return NAMES_TO_CODES.get(langName);
    }
}
