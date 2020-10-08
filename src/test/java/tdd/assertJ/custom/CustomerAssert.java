package tdd.assertJ.custom;

import org.assertj.core.api.AbstractAssert;
import org.mockito.Mockito;
import tdd.customer.Customer;
import tdd.customer.CustomerRepository;
import tdd.customer.NotifyService;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * created by: ufuk on 8.10.2020 19:19
 */
public class CustomerAssert extends AbstractAssert<CustomerAssert, Customer> {

    private CustomerRepository customerRepository;
    private NotifyService notifyService;

    public CustomerAssert(Customer customer, Class<?> selfType, CustomerRepository customerRepository, NotifyService notifyService) {
        super(customer, selfType);
        this.customerRepository = customerRepository;
        this.notifyService = notifyService;
    }

    /**
     * custom assert for gift size
     *
     * @param i
     * @return
     */
    public CustomerAssert hasGifts(int i) {
        assertThat(actual.getGifts())
                .hasSize(i);
        return this;
    }

    public CustomerAssert isSaved() {
        Mockito.verify(customerRepository).save(Mockito.any(Customer.class));
        return this;
    }

    public CustomerAssert isWelcomeMessageSended() {
        Mockito.verify(notifyService).sendEmail(Mockito.any(Customer.class));
        return this;
    }
}
