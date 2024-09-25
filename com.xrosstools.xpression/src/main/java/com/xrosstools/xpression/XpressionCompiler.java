package com.xrosstools.xpression;

import java.util.HashMap;
import java.util.Map;

public class XpressionCompiler extends OperandCompiler {
    private Map<String, OperandCompiler> parserMap = new HashMap<>();

    public XpressionCompiler() {
        initParsers(SINGLE_OPERAND_OPERATOR, new SingleOperandCompiler());
        initParsers(DOUBLE_OPERAND_OPERATOR, new DoubleOperandCompiler());
        initParsers(BETWEEN_OPERATOR, new BetweenCompiler());
        initParsers(IN_OPERATOR, new InCompiler());
    }
    
    private void initParsers(String[] operators, OperandCompiler parser) {
        for(String opr: operators) {
            parserMap.put(opr, parser);
        }
    }
    
    public Expression compile(String leftExpression, String operator, String rightExpression) {
        OperandCompiler parser = parserMap.get(operator);
        if(parser == null)
            throw new IllegalArgumentException("Unidentified operator: " + operator);
            
        return parser.compile(leftExpression, operator, rightExpression);
    }
}
