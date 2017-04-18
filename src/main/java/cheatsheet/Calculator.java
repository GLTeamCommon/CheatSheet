package cheatsheet;

import com.fathzer.soft.javaluator.DoubleEvaluator;

import java.text.ParseException;

public class Calculator {
	public static Double evaluate(String expression)
			throws IllegalArgumentException, NullPointerException {
		DoubleEvaluator evaluator = new DoubleEvaluator();
		return evaluator.evaluate(expression);
	}
}
