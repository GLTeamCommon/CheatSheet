package tests.evaluator;

import cheatsheet.Calculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CalculatorFunctionsTest {

    private Calculator calc ;
    private Double result;
    private static final double DELTA = 1e-14;

    @Before
    public void setResult() {
        result = 0.0;
    }

    @Before
    public void setCalc() {
        calc = new Calculator();
    }

    @Test
    public void evaluateSin1() throws Exception {
        result = calc.evaluate("sin(20)");
        assertEquals(result, 0.9129452507276277, DELTA);
    }

    @Test
    public void evaluateSin2() throws Exception {
        result = calc.evaluate("sin(pi/6)");
        assertEquals(result, 0.5, DELTA);
    }

    @Test
    public void evaluateAsin() throws Exception {
        result = calc.evaluate("asin(0.5)");
        assertEquals(result, 0.5235987755982989, DELTA);
    }

    @Test
    public void evaluateArcsin() throws Exception {
        result = calc.evaluate("arcsin(0.5)");
        assertEquals(result, 0.5235987755982989, DELTA);
    }

    @Test
    public void evaluateCos1() throws Exception {
        result = calc.evaluate("cos(20)");
        assertEquals(result, 0.40808206181339196, DELTA);
    }

    @Test
    public void evaluateCos2() throws Exception {
        result = calc.evaluate("cos(2*pi/3)");
        assertEquals(result, -0.5, DELTA);
    }

    @Test
    public void evaluateArccos() throws Exception {
        result = calc.evaluate("acos(-0.5)");
        assertEquals(result, 2.0943951023931957, DELTA);
    }

    @Test
    public void evaluateTan() throws Exception {
        result = calc.evaluate("tan(pi/4)");
        assertEquals(result, 1.0, DELTA);
    }

    @Test
    public void evaluateAtan() throws Exception {
        result = calc.evaluate("atan(1.5574077246549023)");
        assertEquals(result, 1.0, DELTA);
    }

    @Test
    public void evaluateSqrt() throws Exception {
        result = calc.evaluate("sqrt(4)");
        assertEquals(result, 2.0, DELTA);
    }

    @Test
    public void evaluateExp() throws Exception {
        result = calc.evaluate("e^2");
        assertEquals(result, 7.3890560989306495, DELTA);
    }

    @Test
    public void evaluateLn1() throws Exception {
        result = calc.evaluate("ln(2)");
        assertEquals(result, 0.6931471805599453, DELTA);
    }

    @Test
    public void evaluateLn2() throws Exception {
        result = calc.evaluate("ln(e)");
        assertEquals(result, 1.0, DELTA);
    }

    @Test
    public void evaluateLog() throws Exception {
        result = calc.evaluate("log(100)");
        assertEquals(result, 2.0, DELTA);
    }

    @Test
    public void evaluateComplexExpression1() throws Exception {
        result = calc.evaluate("ln(e^(sin(pi/6)^(-1)))");
        assertEquals(result, 2.0, DELTA);
    }

    @Test
    public void evaluateComplexExpression2() throws Exception {
        result = calc.evaluate("asin(cos(pi))");
        assertEquals(result, -1.5707963267948966, DELTA);
    }

    @Test
    public void evaluateComplexExpression3() throws Exception {
        result = calc.evaluate("2.5*e^(log(100))/cos(pi/3)");
        assertEquals(result, 36.94528049465324, DELTA);
    }
}