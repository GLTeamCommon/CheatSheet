package cheatsheet.result_analysis.number_to_name_converter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erick on 25.02.17.
 */
abstract class AbstractProcessor {
    static protected final String SEPARATOR = " ";
    static protected final int NO_VALUE = -1;

    protected List<Integer> getDigits(long value) {
        ArrayList<Integer> digits = new ArrayList<>();
        if (value == 0) {
            digits.add(0);
        } else {
            while (value > 0) {
                digits.add(0, (int) value % 10);
                value /= 10;
            }
        }
        return digits;
    }

    String getName(long value) {
        return getName(Long.toString(value));
    }

    String getName(double value) {
        return getName(Double.toString(value));
    }

    abstract String getName(String value);
}


