package com.xrosstools.xpression;

import java.lang.reflect.Field;

public class ReferenceExpression extends LeftExpression {
    private String name;

    public ReferenceExpression(String name) {
        super();
        this.name = name;
    }

    @Override
    public Object evaluate(Facts facts) {
        //The first variable
        if(leftExp == null)
            return facts.get(name);

        Object parent = leftExp.evaluate(facts);
        if(parent instanceof EnumType)
            return ((EnumType)parent).valueOf(name);
        
        try {
            Field f = parent.getClass().getDeclaredField(name);
            f.setAccessible(true);
            return f.get(parent);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Unable to access field: " + name, e);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
