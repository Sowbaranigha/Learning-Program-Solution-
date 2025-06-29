// src/main/java/com/example/Calculator.java
package com.example;

public class Calculator {
    private int lastResult;

    public int add(int a, int b) {
        lastResult = a + b;
        return lastResult;
    }

    public int getLastResult() {
        return lastResult;
    }

    public void clear() {
        lastResult = 0;
    }
}
