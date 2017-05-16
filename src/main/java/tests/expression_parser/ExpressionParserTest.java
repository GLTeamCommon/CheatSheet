package tests.expression_parser;

import cheatsheet.expression_parser.ExpressionParser;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ERICK on 16.05.2017.
 */
public class ExpressionParserTest {

    private ExpressionParser expressionParser = null;

    @Test
    public void chooseType1() throws Exception {
        expressionParser = new ExpressionParser("y = sin(x)");
        assertEquals(expressionParser.chooseType().name(), "TWO_VAR_FUNCTION");
    }

    @Test
    public void chooseType2() throws Exception {
        expressionParser = new ExpressionParser("2+x");
        assertEquals(expressionParser.chooseType().name(), "TEXT");
    }

    @Test
    public void chooseType3() throws Exception {
        expressionParser = new ExpressionParser("2+2");
        System.out.println(expressionParser.chooseType());
        assertEquals(expressionParser.chooseType().name(), "ARITHMETIC_EXPRESSION");
    }

    @Test
    public void chooseType4() throws Exception {
        expressionParser = new ExpressionParser(" = sin(x)");
        assertEquals(expressionParser.chooseType().name(), "TEXT");
    }

}