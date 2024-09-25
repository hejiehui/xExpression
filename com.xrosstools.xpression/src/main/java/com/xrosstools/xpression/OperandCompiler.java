package com.xrosstools.xpression;

import java.util.ArrayList;
import java.util.List;

public abstract class OperandCompiler implements XpressionConstants {
    public abstract Expression compile(String leftExpression, String operator, String rightExpression);

    private TokenParser tokenParser = new TokenParser();
    private ExpressionCompiler compiler = new ExpressionCompiler();
    
    public Expression compile(String expressionStr) {
        List<Token> tokens = tokenParser.parseToken(expressionStr);
        return compiler.compile(tokens);
    }
    
    public List<Expression> compileParameters(String parametersStr) {
        if(parametersStr == null) {
            ArrayList<Expression> params = new ArrayList<>();
            params.add(RawValue.NULL_OBJ);
            return params;
        }

        List<Token> tokens = tokenParser.parseToken(parametersStr);        
        ParametersExpression params = (ParametersExpression)compiler.compile(ExpressionType.P, tokens);
        return params.getParams();
    }
}
