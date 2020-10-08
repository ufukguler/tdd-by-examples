package tdd.assertJ.custom;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tdd.customer.Customer;
import tdd.customer.CustomerRepository;
import tdd.customer.CustomerService;
import tdd.customer.NotifyService;

/**
 * created by: ufuk on 8.10.2020 18:58
 */
public class CustomAssertRest {
    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private NotifyService notifyService;

    public static final String username = "ufuk";
    public static final int id = 1;

    @Before
    public void setUp() {
        customerService = new CustomerService();
        customerRepository = Mockito.mock(CustomerRepository.class);
        notifyService = Mockito.mock(NotifyService.class);

        customerService.setCustomerRepository(customerRepository);
        customerService.setNotifyService(notifyService);
    }

    @Test
    public void testCustomAssertJUnit() {
        Customer customer = customerService.handleNewCustomer(username, id);
        customerService.welcomeGift(customer);

        Mockito.verify(customerRepository).save(Mockito.any(Customer.class));
        Mockito.verify(notifyService).sendEmail(customer);

        Assert.assertEquals(1, customer.getGifts().size());
        Assert.assertEquals("myGift", customer.getGifts().get(0).getName());
    }

    /**
     * test with our custom assert class
     */
    @Test
    public void testCustomAssert() {
        Customer customer = customerService.handleNewCustomer(username, id);
        assertThatCustomer(customer)
                .describedAs("error goes here")
                .isSaved()
                .isWelcomeMessageSended()
                .hasGifts(customer.getGifts().size());
    }

    /**
     * our own custom assert method
     * @param customer
     * @return
     */
    private CustomerAssert assertThatCustomer(Customer customer) {
        return new CustomerAssert(customer, CustomerAssert.class, customerRepository, notifyService);
    }
}
