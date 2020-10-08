package tdd.throwE;

/**
 * created by: ufuk on 8.10.2020 14:27
 */
public class NotifyService {
    public void sendEmail() throws Exception {
        throw new Exception("email error");
    }
}
