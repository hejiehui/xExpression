package com.xrosstools.xpression;

import java.util.List;

public class InCompiler extends OperandCompiler {
    public Expression compile(String leftExpression, String operator, String rightExpression) {
        List<Expression> params = compileParameters(rightExpression);
        if(params.size() == 0)
            throw new IllegalArgumentException("IN/NOT IN requires at least one parameter");

        return new InExpression(compile(leftExpression), operator, params.toArray(new Expression[params.size()]));
    }
}
