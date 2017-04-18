package cheatsheet;
import cheatsheet.result_analysis.number_to_name_converter.NumberToWords;

public class Request {
    private String content;
    private String expressionResult;
    private NumberToWords numberToWordsConverter;

    public String getAnswer() {

        try {
            this.expressionResult = Calculator.evaluate(this.content).toString();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Enter correct statement, please";
        } catch (NullPointerException e) {
            e.printStackTrace();
            return "Fill the field, please";
        }
        return this.expressionResult;
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