package cheatsheet.javaluator_extension;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Function;
import com.fathzer.soft.javaluator.Parameters;

import java.util.Iterator;

public class ExtendedEvaluator extends DoubleEvaluator implements FunctionsArray {
    private static final Parameters DEFAULT_PARAMS;

    static {
        DEFAULT_PARAMS = DoubleEvaluator.getDefaultParameters();
        for (ExtendedFunction func: EXTENDED_FUNCTIONS) {
            DEFAULT_PARAMS.add(new Function(func.getFunctionName(),
                    func.getMinParams(), func.getMaxParams()));
        }
    }

    public ExtendedEvaluator() {
        super(DEFAULT_PARAMS);
    }

    @Override
    protected Double evaluate(Function function, Iterator<Double> arguments, Object evaluateContext) {
        for (ExtendedFunction func: EXTENDED_FUNCTIONS) {
            if (function.getName().equalsIgnoreCase(func.getFunction().getName())) {
                return FunctionChooser.chooseFunction(func.getFunctionName(),
                        arguments.next());
            }
        }
        return super.evaluate(function, arguments, evaluateContext);
    }
}
