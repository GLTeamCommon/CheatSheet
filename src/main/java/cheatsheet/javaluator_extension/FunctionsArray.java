package cheatsheet.javaluator_extension;

import java.util.Objects;

/**
 * Created by ERICK on 19.04.2017.
 */
public interface FunctionsArray {
    ExtendedFunction[] EXTENDED_FUNCTIONS = {
            new ExtendedFunction("sqrt", 1, 1),
            new ExtendedFunction("arcsin", 1, 1),
            new ExtendedFunction("arccos", 1, 1),
            new ExtendedFunction("arctan", 1, 1),
            new ExtendedFunction("arcctan", 1, 1),
            new ExtendedFunction("arctg", 1, 1),
            new ExtendedFunction("arcctg", 1, 1),
            new ExtendedFunction("tg", 1, 1)
    };

}
