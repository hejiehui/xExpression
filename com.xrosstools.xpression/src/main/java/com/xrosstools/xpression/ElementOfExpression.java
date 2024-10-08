package com.xrosstools.xpression;

public class ElementOfExpression extends LeftExpression {
    private Expression index;

    public ElementOfExpression(Expression index) {
        this.index = index;
    }

    @Override
    public Object evaluate(Facts facts) {
        Object[] list = (Object[])leftExp.evaluate(facts);
        return list[((Number)index.evaluate(facts)).intValue()];
    }
}
