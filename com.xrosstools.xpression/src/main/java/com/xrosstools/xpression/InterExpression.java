package com.xrosstools.xpression;

import java.util.ArrayList;
import java.util.List;

public class InterExpression implements Expression {
    private List<Object> segment = new ArrayList<>();
    private Grammar g;
    public InterExpression(List<Object> segment, Grammar g) {
        super();
        this.segment = segment;
        this.g = g;
    }
    public List<Object> getSegment() {
        return segment;
    }
    public Grammar getG() {
        return g;
    }
    @Override
    public Object evaluate(Facts facts) {
        return null;
    }
}
