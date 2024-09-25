package com.xrosstools.xpression;

import java.util.List;

public class DoubleOperandCompiler extends OperandCompiler {
    public Expression compile(String leftExpression, String operator, String rightExpression) {
        List<Expression> params = compileParameters(rightExpression);
        if(params.size() != 1)
            throw new IllegalArgumentException("Only one expression is allowed: " + rightExpression);

        return new DoubleOperandExpression(compile(leftExpression), operator, params.get(0));
    }
}
