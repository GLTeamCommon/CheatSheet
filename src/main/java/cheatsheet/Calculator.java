package cheatsheet;

import cheatsheet.javaluator_extension.ExtendedEvaluator;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Calculator {
	private static final String DECIMAL_ROUND_OF_FORMAT = "0.00000000000000";

	public Double evaluate(String expression)
			throws IllegalArgumentException, NullPointerException, ParseException {
		ExtendedEvaluator evaluator = new ExtendedEvaluator();

		DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_ROUND_OF_FORMAT);
		String format = decimalFormat.format(evaluator.evaluate(expression));

		return this.convertDouble(decimalFormat.parse(format));
	}

	private double convertDouble(Object longValue) throws IllegalArgumentException{
		double valueTwo;

		if(longValue instanceof Long) {
			valueTwo = ((Long) longValue).doubleValue();
		} else if (longValue instanceof Double){
			valueTwo = (Double)longValue;
		} else {
			throw new IllegalArgumentException();
		}

		return valueTwo;
	}
}
