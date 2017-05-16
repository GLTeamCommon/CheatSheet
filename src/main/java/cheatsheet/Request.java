package cheatsheet;
import cheatsheet.result_analysis.number_to_name_converter.NumberToWords;

import java.text.ParseException;

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
            return "Enter correct statement, please";
        } catch (NullPointerException e) {
            return "Fill the field, please";
        } finally {
            return this.expressionResult;
        }
    }

    public String getNameOfNumber() {
        this.numberToWordsConverter = new NumberToWords(expressionResult);
        return this.numberToWordsConverter.getName();
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}