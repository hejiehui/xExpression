package com.xrosstools.xpression.sample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        ExpressionCompilerTest.class,
        TokenParserTest.class,
        XrossExpressionCompilerTest.class,
})
public class AllTests  {

}
