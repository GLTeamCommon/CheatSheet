/**
 * Created by erick on 03.04.17.
 */

package src.tests;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Before
    public void runBeforeEveryTest() {
        calc.currentTotal = 0;
    }

    @Test
    public void testGetTotalStringInt() throws Exception {
        calc.currentTotal = 50;
        assertTrue(calc.currentTotal % 1.0 == 0);
    }

    @Test
    public void testGetTotalStringDouble() throws Exception {
        calc.equal("50.5");
        assertTrue(calc.currentTotal % 1.0 != 0);
    }

    @Test
    public void testEqual() throws Exception {
        calc.equal("20");
        assertEquals(calc.currentTotal, 20.0);
    }

    @Test
    public void testAdd() throws Exception {
        calc.add(20);
        assertEquals(calc.currentTotal, 20.0);

    }

    @Test
    public void testSubtract() throws Exception {
        calc.subtract(20);
        assertEquals(calc.currentTotal, -20.0);
    }

    @Test
    public void testMultiplyByZero() throws Exception {
        calc.multiply(10);
        assertEquals(calc.currentTotal, 0.0);
    }

    @Test
    public void testDivideByZero() throws Exception {
        calc.divide(10);
        assertEquals(calc.currentTotal, 0.0);
    }

    @Test
    public void testMultiply() throws Exception {
        calc.add(10);
        calc.multiply(10);
        assertEquals(calc.currentTotal, 100.0);
    }

    @Test
    public void testDivide() throws Exception {
        calc.add(10);
        calc.divide(10);
        assertEquals(calc.currentTotal, 1.0);
    }
}