package com.xrosstools.xpression;

import java.util.List;

public class BetweenCompiler extends OperandCompiler {
    public Expression compile(String leftExpression, String operator, String rightExpression) {
        List<Expression> params = compileParameters(rightExpression);
        if(params.size() != 2)
            throw new IllegalArgumentException(String.format("BETWEEN/NOT BETWEEN requires exactly 2 parameters. Please check the format of : ", rightExpression));
        
        return new BetweenExpression(compile(leftExpression), operator, params.get(0), params.get(1));
    }
}
