package cheatsheet.result_analysis.number_to_name_converter;

/**
 * Created by erick on 27.02.17.
 */
public class ScaleUnit {
    private int exponent;
    private String[] names;

    ScaleUnit(int exponent, String... names) {
        this.exponent = exponent;
        this.names = names;
    }

    int getExponent() {
        return exponent;
    }

    String getName(int index) {
        return names[index];
    }
}
