package tdd.junit;

import org.junit.*;

/**
 * created by: ufuk on 8.10.2020 13:20
 */
public class JUnitAnnotations {

    @Test
    public void test() {
        System.out.println("test 1");
    }
    @Test
    public void test2() {
        System.out.println("test 2");
    }


    @Before
    public void before() {
        System.out.println("before method");
    }

    @After
    public void after() {
        System.out.println("after method\n");
    }


    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class\n");
    }
}
