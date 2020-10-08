package tdd.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tdd.customer.CustomerRepository;
import tdd.customer.CustomerService;
import tdd.customer.NotifyService;

/**
 * created by: ufuk on 8.10.2020 21:25
 */

@RunWith(MockitoJUnitRunner.class)
public class AnnotationTest {

    /**
     * -> @InjectMocks creates an instance of the class and injects the mocks
     * that are created with the @Mock or @Spy annotations into this instance.
     */
    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private NotifyService notifyService;

    @Test
    public void testAnnotation() {
        customerService.handleNewCustomer("ufuk", 1);
    }


}
