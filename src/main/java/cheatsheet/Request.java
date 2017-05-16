package cheatsheet;
import cheatsheet.result_analysis.number_to_name_converter.NumberToWords;

import java.text.ParseException;
import java.lang.NullPointerException;
import java.lang.NumberFormatException;

public class Request {
    private String content;
    private String expressionResult;
    private NumberToWords numberToWordsConverter;
    private Calculator calculator;

    {
        calculator = new Calculator();
    }

    public String getAnswer() {
        try {
            this.expressionResult = calculator.processExpression(this.content);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            return this.expressionResult;
        }
    }

    public String getNameOfNumber() {
        String result = new String();
        try {
            this.numberToWordsConverter = new NumberToWords(expressionResult);
            result =  this.numberToWordsConverter.getName();
        } catch (NumberFormatException e) {
            result = "Pats";
        } finally {
            return result;
        }
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsAnswerExist() {
        return new Integer(calculator.getIsAnswerExist()).toString();
    }

    public String getIsNameOfNumberExist() {
        return new Integer(calculator.getIsNameOfNumberExist()).toString();
    }

    public String getGraphicExist() {
        return new Integer(calculator.getGraphicExist()).toString();
    }
}