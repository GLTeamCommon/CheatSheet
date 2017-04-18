package cheatsheet.result_analysis.number_to_name_converter;

/**
 * Created by erick on 22.02.17.
 */
enum Scale {
    SHORT,
    LONG;

    String getName(int exponent) {
        for (ScaleUnit unit : NumberToWords.SCALE_UNITS) {
            if (unit.getExponent() == exponent) {
                return unit.getName(this.ordinal());
            }
        }
        return "";
    }
}


