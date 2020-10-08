package tdd.junit;

import org.junit.Ignore;
import org.junit.Test;

/**
 * created by: ufuk on 8.10.2020 15:41
 */
public class IgnoreTest {

    /**
     * ignored test
     */
    @Test
    @Ignore("depraced")
    public void testIgnored() {
        System.out.println("ignored test");
    }

}