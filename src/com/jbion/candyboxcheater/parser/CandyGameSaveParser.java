package com.jbion.candyboxcheater.parser;

import java.util.HashMap;
import java.util.Map;

import com.jbion.candyboxcheater.game.GameKey;
import com.jbion.candyboxcheater.game.GameState;
import com.jbion.candyboxcheater.game.variables.Variable;

public class CandyGameSaveParser {

    private static final int TYPE = 0;
    private static final int NAME = 1;
    private static final int VALUE = 2;

    public static Map<GameKey, Variable> parse(String testSave) {

        Map<GameKey, Variable> save = new HashMap<>();

        String[] variables = testSave.split(",");
        for (String varDeclaration : variables) {
            String[] var = parseVariableDeclaration(varDeclaration);
            Variable v = Variable.create(var[TYPE], var[NAME], var[VALUE]);
            save.put(v.getKey(), v);
        }
        return save;
    }

    public static void parseAndUpdate(String testSave, Map<GameKey, Variable> vars) {

        String[] variables = testSave.split(",");
        for (String varDeclaration : variables) {
            String[] var = parseVariableDeclaration(varDeclaration);
            Variable oldVar = vars.get(GameKey.valueOf(var[NAME]));
            oldVar.set(var[VALUE]);
        }
    }

    private static String[] parseVariableDeclaration(String varDeclaration) {
        // separate type from init
        String[] typeSeparation = varDeclaration.trim().split("\\s");
        // separate name from value
        String[] varInitialization = typeSeparation[1].split("=");
        String[] result = new String[3];
        result[TYPE] = typeSeparation[0];
        result[NAME] = varInitialization[0];
        result[VALUE] = varInitialization[1];
        return result;
    }
}
