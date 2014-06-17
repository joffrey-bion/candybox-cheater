package com.jbion.candyboxcheater.view.converters;

public class NumberToStringMapping extends StringMapping<Number> {
	
	public NumberToStringMapping(String... values) {
		for (int i = 0; i < values.length; i++) {
			put(i, values[i]);
		}
	}
	
	@Override
	protected void put(Number code, String name) {
		super.put(code.intValue(), name);
	}
	
	@Override
    public String toString(Number number) {
		return super.toString(number.intValue());
    }
	
    @Override
    public Number fromString(String string) {
    	Number n = super.fromString(string);
    	return n == null ? 0 : n.intValue();
    }
}
