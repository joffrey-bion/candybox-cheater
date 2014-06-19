package com.jbion.candyboxcheater.parser;

import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.jbion.candyboxcheater.game.Key;
import com.jbion.candyboxcheater.game.variables.Variable;

public class CandyGameSaveParser {

	private static final int TYPE = 0;
	private static final int NAME = 1;
	private static final int VALUE = 2;

	/**
	 * Parses the specified CandyBox save text into a new map of initialized
	 * variables.
	 * 
	 * @param textSave
	 *            the CandyBox game save, as text
	 * @return the created {@link Map} of variables
	 * @throws ParseException
	 *             if an error occurred during parsing
	 */
	public static Map<Key, Variable> parse(String textSave) throws ParseException {
		Map<Key, Variable> vars = new HashMap<>();
		parseAndUpdate(textSave, vars);
		return vars;
	}

	/**
	 * Parses the specified CandyBox save text and updates the specified map of
	 * variables. Each variable is either created and added to the map (if not
	 * already there), or updated.
	 * 
	 * @param textSave
	 *            the CandyBox game save, as text
	 * @param vars
	 *            the Map of variables to update or populate
	 * @throws ParseException
	 *             if an error occurred during parsing
	 */
	public static void parseAndUpdate(String textSave, Map<Key, Variable> vars) throws ParseException {
		String[] variables = textSave.split(",");
		int errorOffset = 0;
		for (String varDeclaration : variables) {
			try {
				parseAndAddVariable(varDeclaration, vars);
			} catch (ParseException e) {
				throw new ParseException(e.getMessage(), e.getErrorOffset() + errorOffset);
			}
			errorOffset += varDeclaration.length();
		}
		List<String> missingVars = getMissingVariables(vars);
		if (missingVars.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (String var : missingVars) {
				sb.append(var).append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());
			throw new ParseException("Missing game variables: " + sb.toString(), textSave.length());
		}
	}

	/**
	 * Parses the specified variable declaration. It then creates the corresponding
	 * variable and adds it to the specified map, or simply updates the existing
	 * variable if it's already there.
	 * 
	 * @param varDeclaration
	 *            the {@link String} representing the variable declaration to parse
	 *            (excluding the comma)
	 * @param vars
	 *            the map of variables to update or populate
	 * @throws ParseException
	 *             if an error occurred during parsing
	 */
	private static void parseAndAddVariable(String varDeclaration, Map<Key, Variable> vars) throws ParseException {
		String[] var = splitVariableDeclaration(varDeclaration);
		if (!Key.exists(var[NAME])) {
			throw new ParseException("Unknown variable '" + var[NAME] + "', it does not exist in CandyBox!",
					varDeclaration.indexOf(var[NAME]));
		}
		if (!Variable.isValidType(var[TYPE])) {
			throw new ParseException("Unknown type '" + var[TYPE] + "'.", varDeclaration.indexOf(var[TYPE]));
		}
		Variable oldVar = vars.get(Key.valueOf(var[NAME]));
		if (oldVar == null) {
			Variable v = Variable.create(var[TYPE], var[NAME], var[VALUE]);
			vars.put(v.getKey(), v);
		} else {
			oldVar.setStringValue(var[VALUE]);
		}
	}

	/**
	 * Splits the specified variable into an array.
	 * 
	 * @param varDeclaration
	 *            the variable declaration to parse
	 * @return an array containing 3 strings: the type, name and value of the
	 *         variable, at their respective indices {@link #TYPE}, {@link #NAME},
	 *         {@link #VALUE}.
	 * @throws ParseException
	 *             if an error occurred during parsing
	 */
	private static String[] splitVariableDeclaration(String varDeclaration) throws ParseException {
		// separate type from init
		String[] typeSeparation = varDeclaration.trim().split("\\s");
		if (typeSeparation.length < 2) {
			throw new ParseException("Missing space in variable declaration. "
					+ "There should be a space between the type and the name of the variable. Found: '"
					+ varDeclaration + "'", 0);
		}
		if (typeSeparation.length > 2) {
			throw new ParseException("Extra space(s) in variable declaration. "
					+ "There should only be one space: between the type and the name of the variable.",
					typeSeparation[1].length());
		}
		// separate name from value
		String[] varInitialization = typeSeparation[1].split("=");
		if (varInitialization.length < 2) {
			throw new ParseException("Missing '=' in variable declaration. "
					+ "There should be a '=' between the name and the value of the variable. Found: '"
					+ varInitialization[0] + "'", 0);
		}
		if (varInitialization.length > 2) {
			throw new ParseException("Extra '=' sign(s) in variable declaration.\n"
					+ "There should only be one '=': between the name and the value of the variable.\nFound: '"
					+ typeSeparation[1] + "'", varInitialization[1].length());
		}
		String[] result = new String[3];
		result[TYPE] = typeSeparation[0];
		result[NAME] = varInitialization[0];
		result[VALUE] = varInitialization[1];
		return result;
	}

	/**
	 * Returns a list of variables that are missing in the specified map, compared to
	 * the possible {@link Key}s.
	 * 
	 * @param vars
	 *            the map of variables to check
	 * @return the list of missing variables
	 */
	private static List<String> getMissingVariables(Map<Key, Variable> vars) {
		Key[] allKeys = Key.values();
		List<String> missingVars = new LinkedList<>();
		for (Key key : allKeys) {
			if (vars.get(key) == null) {
				missingVars.add(key.name());
			}
		}
		return missingVars;
	}
}
