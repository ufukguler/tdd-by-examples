package tdd.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by: ufuk on 7.10.2020 18:33
 */
public class CustomerRepositoryStub extends CustomerRepository {

    private Map<Integer, Customer> customerList = new HashMap<>();

    @Override
    void save(Customer customer) {
        customerList.put(customer.id, customer);
    }

    @Override
    void delete(Integer customerId) {
        customerList.remove(customerId);
    }

    @Override
    Customer findById(Integer customerId) {
        return customerList.get(customerId);
    }

}
