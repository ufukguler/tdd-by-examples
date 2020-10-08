package tdd.customer;

import tdd.lombok.Gift;

/**
 * created by: ufuk on 7.10.2020 18:12
 */
public class CustomerService {

    CustomerRepository customerRepository;
    NotifyService notifyService;

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
        notifyService.sendEmail(customer);
    }

    public void deleteCustomer(Integer customerId) {
        customerRepository.delete(customerId);
    }

    public void setNotifyService(NotifyService notifyService) {
        this.notifyService = notifyService;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer handleNewCustomer(String username, int id) {
        Customer customer = new Customer(username, id);
        customerRepository.save(customer);
        notifyService.sendEmail(customer);
        return customer;
    }
    public void welcomeGift(Customer customer){
        customer.addGift(new Gift("myGift"));
    }
}
