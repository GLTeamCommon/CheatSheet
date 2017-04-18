package cheatsheet.result_analysis.number_to_name_converter;

/**
 * Created by Erick MIzhevich on 28.02.17.
 */
public class ExponentProcessor extends AbstractProcessor {

    static private String EXP_VALUE = " ten ";
    static private String EXP_VALUE_SEPARATOR = " by";
    static private String EXP_SEPARATOR = "to the ";

    private AbstractProcessor processor = new DefaultProcessor();

    @Override
    public String getName(String value) {
        String[] numberParts = value.toUpperCase().split("E");

        return processor.getName(numberParts[0])
                .concat(EXP_VALUE_SEPARATOR)
                .concat(EXP_VALUE)
                .concat(EXP_SEPARATOR)
                .concat(processor.getName(numberParts[1]));
    }
}
