package tdd.lombok;

import org.junit.Test;

/**
 * created by: ufuk on 8.10.2020 16:00
 */
public class LombokTest {

    @Test
    public void testLombok() {
        Gift gift = Gift.builder().name("myGift").build();
        System.out.println(gift.toString());
    }
}
