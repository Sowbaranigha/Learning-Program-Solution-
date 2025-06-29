package com.example;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedTests {

    @Test @Order(1)
    void first() { System.out.println("1st"); }

    @Test @Order(3)
    void third() { System.out.println("3rd"); }

    @Test @Order(2)
    void second() { System.out.println("2nd"); }
}
