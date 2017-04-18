package cheatsheet;

import com.fathzer.soft.javaluator.DoubleEvaluator;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Calculator {
	public Double evaluate(String expression)
			throws IllegalArgumentException, NullPointerException, ParseException {
		DoubleEvaluator evaluator = new DoubleEvaluator();

		DecimalFormat df = new DecimalFormat("0.00000000000000");
		String format = df.format(evaluator.evaluate(expression));

		return this.convertDouble(df.parse(format));
	}

	private double convertDouble(Object longValue) throws IllegalArgumentException{
		double valueTwo = -1.0;

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
