package cheatsheet.javaluator_extension;

/**
 * Created by ERICK on 19.04.2017.
 */
public class FunctionChooser {
    public static Double chooseFunction(String functionName, Double arg) {
        switch (functionName.toLowerCase()) {
            case "sqrt":
                return Math.sqrt(arg);
            case "arcsin":
                return Math.asin(arg);
            case "arccos":
                return Math.acos(arg);
            case "arctan":
            case "arctg":
                return Math.atan(arg);
            case "arcctan":
            case "arcctg":
                return 1 / Math.atan(arg);
            case "tg":
                return Math.tan(arg);
        }
        return null;
    }
}
