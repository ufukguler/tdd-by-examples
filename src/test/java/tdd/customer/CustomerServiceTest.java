package tdd.customer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerServiceTest {

    private CustomerService customerService;
    private final CustomerRepositoryStub customerRepository = new CustomerRepositoryStub();
    private NotifyService notifyService;

    @BeforeAll
    public void setUp() {
        customerService = new CustomerService();
        notifyService = Mockito.mock(NotifyService.class);

        customerService.setNotifyService(notifyService);
        customerService.setCustomerRepository(customerRepository);
    }

    @Test
    void testCustomerSave() {
        Customer customer = new Customer("customer", 1);
        customerService.saveCustomer(customer);
        assertEquals(customer, customerRepository.findById(customer.getId()));
        Mockito.verify(notifyService).sendEmail(customer);
    }

    @Test
    void testCustomerDelete() {

        Customer customer = new Customer("customer", 2);
        customerService.saveCustomer(customer);

        assertNotNull(customerRepository.findById(2));

        customerService.deleteCustomer(2);
        assertNull(customerRepository.findById(2));
    }
}