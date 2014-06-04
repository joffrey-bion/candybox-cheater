package com.jbion.candyboxcheater.view.converters;

public class NumberToStringMapping extends StringMapping<Number> {
	
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
