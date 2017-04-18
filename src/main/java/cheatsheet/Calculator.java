package cheatsheet;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class Calculator {
	public static Double evaluate(String expression) {
		DoubleEvaluator evaluator = new DoubleEvaluator();

		return evaluator.evaluate(expression);
	}
}
