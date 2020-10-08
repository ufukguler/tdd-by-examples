package tdd.calculator;

import junitparams.*;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ParametersExampleTest {

    private Object[] plus() {
        return new Integer[][]{
                new Integer[]{1, 2, 3},
                new Integer[]{-5, 2, -3},
                new Integer[]{5, -2, 3},
                new Integer[]{-4, -7, -11}
        };
    }

    @Test
    @Parameters(method = "plus")
    @TestCaseName(" | {0} + {1} = {2}")
    public void plusTest1(int a, int b, int result) {
        assertEquals(result, Calculator.plus(a, b));
    }

    @Test
    @Parameters({"1, 1, 2", "3, -4, -1"})
    public void plusTest2(int a, int b, int result) {
        assertEquals(result, Calculator.plus(a, b));
    }
}
