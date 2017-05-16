package cheatsheet.expression_parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ERICK on 15.05.2017.
 */
public class ExpressionParser {
    private String expression;
    private Pattern pattern;
    private Matcher[] matcher = new Matcher[2];

    private static final String FUNC_LEFT_PART_PATTERN = "^\\s*[x-z]\\s*$";
    private static final String FUNC_RIGHT_PART_PATTERN = "^*[x-z]*$";
    private static final String ARITHMETIC_PATTERN = "^\\s*[0-9]*\\s*[+*-/%^!]+\\s*[0-9]+$";
    private static final String LETTERS_PATTERN = "^[A-Za-z ]*$";

    public ExpressionParser(String expression) {
        this.expression = expression;
    }

    public ExpressionTypes chooseType() {
        if (isWikiRequest()) {
            return ExpressionTypes.TEXT;
        } else if (isMathFunction()) {
            return ExpressionTypes.TWO_VAR_FUNCTION;
        } else {
            return ExpressionTypes.ARITHMETIC_EXPRESSION;
        }
    }

    private boolean isArithmeticExpression() {
        this.pattern = Pattern.compile(ARITHMETIC_PATTERN);
        this.matcher[0] = this.pattern.matcher(this.expression);
        if (this.matcher[0].find()) {
            System.out.println("Found arithmetic");
            return true;
        } else {
            System.out.println("No arithmetic");
            return false;
        }
    }

    private boolean isMathFunction() {
        String[] splitedExpr;
        if(this.expression.contains("=")) {
            splitedExpr = this.expression.split("=");
        } else {
            System.out.println("No function");
            return false;
        }
        this.pattern = Pattern.compile(FUNC_LEFT_PART_PATTERN);
        this.matcher[0] = this.pattern.matcher(splitedExpr[0]);
        this.pattern = Pattern.compile(FUNC_RIGHT_PART_PATTERN);
        this.matcher[1] = this.pattern.matcher(splitedExpr[1]);
        if (this.matcher[0].find() && this.matcher[1].find()) {
            System.out.println("Found function: ");
            return true;
        } else {
            System.out.println("No function");
            return false;
        }
    }

    private boolean isWikiRequest() {
        this.pattern = Pattern.compile(LETTERS_PATTERN);
        this.matcher[0] = this.pattern.matcher(this.expression);
        if (this.matcher[0].find()) {
            System.out.println("Found wiki request");
            return true;
        } else {
            System.out.println("No wiki request");
            return false;
        }
    }
}
