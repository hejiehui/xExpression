package com.xrosstools.xpression;

public class SingleOperandCompiler extends OperandCompiler {
    public Expression compile(String leftExpression, String operator, String rightExpression) {
        if(rightExpression != null && rightExpression.length() != 0)
            throw new IllegalArgumentException(String.format("s% does not require extra parameter s%", operator, rightExpression));
        
        return new SingleOperandExpression(compile(leftExpression), operator);
    }
}
