package tdd.customer;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

import static org.junit.Assert.*;


public class CustomerServiceTest {

    private CustomerService customerService;
    private final CustomerRepositoryStub customerRepository = new CustomerRepositoryStub();
    private NotifyService notifyService;

    /**
     * runs before all tests
     */
    @Before
    public void setUp() {
        customerService = new CustomerService();
        notifyService = Mockito.mock(NotifyService.class);

        customerService.setNotifyService(notifyService);
        customerService.setCustomerRepository(customerRepository);
    }

    @Test
    public void testCustomerSave() {
        Customer customer = new Customer("customer", 1);
        customerService.saveCustomer(customer);
        assertEquals(customer, customerRepository.findById(customer.getId()));
        Mockito.verify(notifyService).sendEmail(customer);
    }

    @Test
    public void testCustomerDelete() {

        Customer customer = new Customer("customer", 2);
        customerService.saveCustomer(customer);

        assertNotNull(customerRepository.findById(2));

        customerService.deleteCustomer(2);
        assertNull(customerRepository.findById(2));
    }
}