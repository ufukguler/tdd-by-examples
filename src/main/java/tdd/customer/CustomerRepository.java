package tdd.customer;

/**
 * created by: ufuk on 7.10.2020 18:13
 */
public class CustomerRepository {
    void save(Customer customer) {
        System.out.println("saved customer: " + customer.toString());
    }

    void delete(Integer customerId) {
        System.out.println("deleted the customer with id: " + customerId);
    }

    Customer findById(Integer customerId) {
        System.out.println("finding customer with id: " + customerId);
        return null;
    }
}
