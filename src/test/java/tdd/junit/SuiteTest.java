package tdd.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tdd.calculator.ParametersExampleTest;
import tdd.customer.CustomerServiceTest;
import tdd.tdd.MoneyTest;
import tdd.throwE.NotifyServiceTest;

/**
 * created by: ufuk on 8.10.2020 15:30
 * run these tests in the given order as a group
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ParametersExampleTest.class,
        CustomerServiceTest.class,
        AssertTests.class,
        JUnitAnnotations.class,
        NotifyServiceTest.class,
        MoneyTest.class,
        IgnoreTest.class
})
public class SuiteTest {

}
