package tests.evaluator;

import cheatsheet.Calculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorExpressionsTest {

    Calculator calc;
    Double result;
    private static final double DELTA = 1e-15;

    @Before
    public void setResult() {
        result = new Double(0.0);
    }

    @Before
    public void setCalc() {
        calc = new Calculator();
    }

    @Test
    public void evaluateIntSum() throws Exception {
        result = calc.evaluate("2+2");
        assertEquals(result, 4.0, DELTA);
    }

    @Test
    public void evaluateDoubleSum() throws Exception {
        result = calc.evaluate("2.1+3.2");
        assertEquals(result, 5.3, DELTA);
    }

    @Test
    public void evaluateIntDiff() throws Exception {
        result = calc.evaluate("5-2");
        assertEquals(result, 3.0, DELTA);
    }

    @Test
    public void evaluateDoubleDiff() throws Exception {
        result = calc.evaluate("3.2-2.1");
        assertEquals(result, 1.1, DELTA);
    }

    @Test
    public void evaluateIntMult() throws Exception {
        result = calc.evaluate("5*3");
        assertEquals(result, 15.0, DELTA);
    }

    @Test
    public void evaluateDoubleMult() throws Exception {
        result = calc.evaluate("3.1*2.5");
        assertEquals(result, 7.75, DELTA);
    }

    @Test
    public void evaluateIntDiv() throws Exception {
        result = calc.evaluate("6/3");
        assertEquals(result, 2.0, DELTA);
    }

    @Test
    public void evaluateDoubleDiv() throws Exception {
        result = calc.evaluate("7.75/2.5");
        assertEquals(result, 3.1, DELTA);
    }

    @Test
    public void evaluateIntPow() throws Exception {
        result = calc.evaluate("2^3");
        assertEquals(result, 8.0, DELTA);
    }

    @Test
    public void evaluateDoublePow() throws Exception {
        result = calc.evaluate("2.5^2.5");
        assertEquals(result, 9.882117688026186, DELTA);
    }

    @Test
    public void evaluateIntSimpleExpression() throws Exception {
        result = calc.evaluate("3-4+2*5");
        assertEquals(result, 9.0, DELTA);
    }

    @Test
    public void evaluateDoubleSimpleExpression() throws Exception {
        result = calc.evaluate("7.5-2.5*2.5");
        assertEquals(result, 1.25, DELTA);
    }

    @Test
    public void evaluateMixedSimpleExpression() throws Exception {
        result = calc.evaluate("7.5/3+2*2.5");
        assertEquals(result,  7.5, DELTA);
    }

    @Test
    public void evaluateSimpleIntExpressionWithBrackets() throws Exception {
        result = calc.evaluate("(7-2)*3+2*(2+1)");
        assertEquals(result, 21.0, DELTA);
    }

    @Test
    public void evaluateSimpleDoubleExpressionWithBrackets() throws Exception {
        result = calc.evaluate("(7.5-3)*(2+1.5)");
        assertEquals(result, 15.75, DELTA);
    }

    @Test
    public void evaluateSimpleIntNegativeExpression() throws Exception {
        result = calc.evaluate("(7-2)*(-3)+1");
        assertEquals(result, -14.0, DELTA);
    }

    @Test
    public void evaluateSimpleDoubleNegativeExpression() throws Exception {
        result = calc.evaluate("(7.5-3)*(1.5-2)");
        assertEquals(result, -2.25, DELTA);
    }
}