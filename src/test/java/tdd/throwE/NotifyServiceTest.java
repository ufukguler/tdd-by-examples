package tdd.throwE;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

public class NotifyServiceTest {

    private NotifyService notifyService = new NotifyService();

    /**
     * pros -> able to check the error message
     */
    @Test
    public void sendEmailTest1() {
        try {
            notifyService.sendEmail();
        } catch (Exception e) {
            assertTrue(e instanceof Exception);
            assertEquals("email error", e.getMessage());
        }
    }

    /**
     * cons -> not able check the error message
     *
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void sendEmailTest2() throws Exception {
        notifyService.sendEmail();
    }

    /**
     * catch the thrown exception by using ExpectedException
     */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testRuleException() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("email error");

        notifyService.sendEmail();
    }


}