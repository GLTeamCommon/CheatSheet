package cheatsheet;

import cheatsheet.expression_parser.ExpressionParser;
import cheatsheet.javaluator_extension.ExtendedEvaluator;
import com.fathzer.soft.javaluator.StaticVariableSet;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashMap;

public class Calculator {
	private static final String DECIMAL_ROUND_OF_FORMAT = "0.00000000000000";
	private static final int[] PLOT_BUILD_BOUNDS = new int[]{-100, 100};
	private static final double PLOT_BUILD_STEP = 0.1;
	private final HashMap<Double, Double> coords = new HashMap<>();
	private Double evaluateResult;

	public String processExpression(final String expression) throws IllegalArgumentException,
			NullPointerException, ParseException {
		ExpressionParser parser = new ExpressionParser(expression);
		switch(parser.chooseType()) {
			case ARITHMETIC_EXPRESSION:
				evaluate(expression);
				return (this.evaluateResult.toString());
			case TWO_VAR_FUNCTION:
				buildPlot(expression);
				return (this.coords.keySet().toString()
						.concat("$")
						.concat(coords.values().toString())
						.replaceAll(" ", "")
						.replace("[", "")
						.replace("]", ""));
			case TEXT:
				//TODO:text processing...
				return null;
			default:
				return "Unsupported input";
		}
	}

	private void buildPlot(String expression) throws IllegalArgumentException,
			NullPointerException, ParseException {
		final ExtendedEvaluator eval = new ExtendedEvaluator();
		final StaticVariableSet<Double> variables = new StaticVariableSet<Double>();
		String variable;
		if (expression.split("=")[1].toLowerCase().contains("x")) {
			variable = "x";
		} else if (expression.split("=")[1].toLowerCase().contains("y")){
			variable = "y";
		} else {
			variable = "z";
		}
		for (double step = PLOT_BUILD_BOUNDS[0]; step < PLOT_BUILD_BOUNDS[1];
			 	step += PLOT_BUILD_STEP) {
			variables.set(variable, step);
			Double result = eval.evaluate(expression, variables);
			this.coords.put(step, result);
		}
	}

	private void evaluate(String expression)
			throws IllegalArgumentException, NullPointerException, ParseException {
		ExtendedEvaluator evaluator = new ExtendedEvaluator();

		DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_ROUND_OF_FORMAT);
		String format = decimalFormat.format(evaluator.evaluate(expression));
		this.evaluateResult = this.convertDouble(decimalFormat.parse(format));
	}

	private double convertDouble(Object longValue) throws IllegalArgumentException {
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
