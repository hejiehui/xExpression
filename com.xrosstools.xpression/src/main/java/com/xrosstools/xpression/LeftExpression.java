package com.xrosstools.xpression;

public abstract class LeftExpression implements Expression {
    protected Expression leftExp;

    public Expression setLeftExp(Expression leftExp) {
        if(leftExp instanceof EndExpression)
            return this;

        if(this.leftExp == null) {
            this.leftExp = leftExp;
            return this;
        }
        
        if(this.leftExp instanceof LeftExpression) {
            ((LeftExpression)this.leftExp).setLeftExp(leftExp);
            return this;
        }

        throw new IllegalArgumentException(leftExp.toString() + " is not allowed");
    }
}
