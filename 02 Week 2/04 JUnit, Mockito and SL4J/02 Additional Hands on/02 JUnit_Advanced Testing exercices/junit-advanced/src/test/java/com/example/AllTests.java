package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        com.example.MathTest.class,
        com.example.StringTest.class,
        com.example.EvenCheckerTest.class
})
public class AllTests { }
