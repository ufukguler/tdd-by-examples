package tdd.customer;

/**
 * created by: ufuk on 7.10.2020 18:15
 */
public class NotifyService {
    public void sendEmail(Customer customer) {
        System.out.println("sended an email to customer: " + customer.toString());
    }
}
