package cheatsheet.result_analysis.number_to_name_converter;

/**
 * Created by erick on 25.02.17.
 */
public class UnitProcessor extends AbstractProcessor {

    static private final String[] TOKENS = new String[] {
            "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    @Override
    String getName(String value) {
        StringBuilder buffer = new StringBuilder();

        int offset = NO_VALUE;
        int number;
        if (value.length() > 3) {
            number = Integer.valueOf(value.substring(value.length() - 3), 10);
        } else {
            number = Integer.valueOf(value, 10);
        }
        number %= 100;
        if (number < 10) {
            offset = (number % 10) - 1;
        } else if (number < 20) {
            offset = (number % 20) - 1;
        }

        if (offset != NO_VALUE && offset < TOKENS.length) {
            buffer.append(TOKENS[offset]);
        }

        return buffer.toString();
    }
}
