package cheatsheet;
import cheatsheet.result_analysis.number_to_name_converter.NumberToWords;

import java.text.ParseException;
import java.lang.NullPointerException;

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
        try {
            this.numberToWordsConverter = new NumberToWords(expressionResult);
            return this.numberToWordsConverter.getName();
        } catch (NullPointerException e) {
            return "";
        }
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsAnswerExist() {
        return calculator.getIsAnswerExist();
    }

    public int getIsNameOfNumberExist() {
        return calculator.getIsNameOfNumberExist();
    }

    public int getGraphicExist() {
        return calculator.getGraphicExist();
    }
}