package cheatsheet.javaluator_extension;

import com.fathzer.soft.javaluator.Function;

import java.math.MathContext;

/**
 * Created by ERICK on 19.04.2017.
 */
public class ExtendedFunction {
    private String functionName;
    private Integer minParams;
    private Integer maxParams;
    private Function function;

    public ExtendedFunction() {
    }

    public ExtendedFunction(String functionName, Integer minParams, Integer maxParams) {
        this.functionName = functionName;
        this.minParams = minParams;
        this.maxParams = maxParams;
        this.function = new Function(this.functionName, this.getMinParams(), this.getMaxParams());
    }

    public Integer getMinParams() {
        return minParams;
    }

    public void setMinParams(Integer minParams) {
        this.minParams = minParams;
    }

    public Integer getMaxParams() {
        return maxParams;
    }

    public void setMaxParams(Integer maxParams) {
        this.maxParams = maxParams;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }
}
