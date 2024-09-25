package com.xrosstools.xpression;

public class EndExpression extends LeftExpression {
    @Override
    public Object evaluate(Facts facts) {
        throw new IllegalStateException("EndExpression should never be evaluated");
    }
    
    public Expression setLeftExp(Expression leftExp) {
        return leftExp;
    }
    
    public static EndExpression end() {
        return new EndExpression();
    }
}
