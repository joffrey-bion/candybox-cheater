package com.jbion.candyboxcheater.view.converters;

public class StatusBarLevelConverter extends NumberToStringMapping {

    {
        put(0, "No status bar");
        put(1, "Status bar unlocked");
        put(2, "Config button unlocked");
        put(3, "Save button unlocked");
        put(4, "Health bar unlocked");
        put(5, "Map button unlocked");
    }
}