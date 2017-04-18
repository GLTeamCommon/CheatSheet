package cheatsheet.result_analysis.number_to_name_converter;

/**
 * Created by erick on 22.02.17.
 */
public class NumberToWords<TYPE extends Number> implements ScalesArray {

    private String number;
    static Scale SCALE = Scale.SHORT;
    private AbstractProcessor processor;

    public NumberToWords(String number) {
        this.number = number;
    }

    public NumberToWords(TYPE number) {
        this.number = number.toString();
    }

    public String getName() {
        this.number.toUpperCase();
        if (this.number.indexOf('E') != -1) {
            processor = new ExponentProcessor();
            return processor.getName(this.number);
        } else {
            processor = new DefaultProcessor();
            return processor.getName(this.number);
        }
    }
}
