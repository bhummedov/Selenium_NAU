package JUnitClass;

import org.junit.jupiter.api.*;

public class FirstUnit {
    @BeforeAll
    public static void setUp(){
        System.out.println("@BeforeAll executed once before all test methods in this class");
    }
    @AfterAll
    public static void tearDown(){
        System.out.println("@AfterAll executed once before all test methods in this class");
    }

    @BeforeEach
    public void init(){
        System.out.println("@BeforeEach executed once before all test methods in this class");
    }
    @AfterEach
    public void done(){
        System.out.println("@AfterEach executed once before all test methods in this class");
    }
    @Test
    public void test1(){
        System.out.println("Test executed test1");
    }
    @Test
    public void test2(){
        System.out.println("Test executed test2");
    }
    @Test
    public void test3(){
        System.out.println("Test executed test3");
    }
}
