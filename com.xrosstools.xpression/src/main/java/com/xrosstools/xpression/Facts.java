package com.xrosstools.xpression;


public interface Facts {
    String[] getNames();
    boolean contains(String name);
	Object get(String name);
}
