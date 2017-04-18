package cheatsheet.result_analysis.number_to_name_converter;

/**
 * Created by erick on 25.02.17.
 */
class DefaultProcessor extends AbstractProcessor {

    static private String MINUS = "minus";
    static private String UNION_AND = "and";
    static private String ZERO_TOKEN = "zero";

    private AbstractProcessor processor = new CompositeBigProcessor(63);

    @Override
    public String getName(String value) {
        boolean negative = false;
        boolean zeroFractional = true;
        if (value.startsWith("-")) {
            negative = true;
            value = value.substring(1);
        }

        int decimals = value.indexOf(".");
        String decimalValue = null;
        if (0 <= decimals) {
            for (int i = decimals + 1; i < value.length(); i++) {
                if (value.charAt(i) != '0')  {
                    zeroFractional = false;
                    break;
                }
            }
            decimalValue = value.substring(decimals + 1);
            value = value.substring(0, decimals);
        }

        String name = processor.getName(value);

        if (name.isEmpty()) {
            name = ZERO_TOKEN;
        } else if (negative) {
            name = MINUS.concat(SEPARATOR).concat(name);
        }

        if (!(null == decimalValue || decimalValue.isEmpty())) {
            if (zeroFractional) {
                name = name.concat(SEPARATOR).concat(UNION_AND).concat(SEPARATOR)
                        .concat(ZERO_TOKEN)
                        .concat(processor.getName(decimalValue))
                        .concat(SEPARATOR).concat(NumberToWords.SCALE.
                                getName(-decimalValue.length()));
            } else {
                name = name.concat(SEPARATOR).concat(UNION_AND).concat(SEPARATOR)
                        .concat(processor.getName(decimalValue))
                        .concat(SEPARATOR).concat(NumberToWords.SCALE.
                                getName(-decimalValue.length()));
            }
        }

        return name;
    }
}
