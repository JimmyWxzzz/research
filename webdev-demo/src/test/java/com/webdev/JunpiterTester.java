package com.webdev;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
@DisplayName("Junit5 functional test")
public class JunpiterTester {


    @DisplayName("simple assertion")
    @Test
    void testassertion() {
        int cal = cal(2,3);
        Assertions.assertEquals(5, cal, "not true");

    }

    int cal(int i, int j){
        return i+j;
    }
    @BeforeEach
    void testBeforeEach() {
        System.out.println("testing begins");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("testing ends");
    }

    @RepeatedTest(5)
    @Test
    void test(){
        System.out.println("two");
    }

    @BeforeAll
    static void b4all() {
        System.out.println("All tests end");
    }

    @Test
    void testtimeout() throws InterruptedException {
        Thread.sleep(500);
    }



}
