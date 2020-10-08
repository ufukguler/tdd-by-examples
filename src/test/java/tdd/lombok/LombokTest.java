package tdd.lombok;

import org.junit.Test;

/**
 * created by: ufuk on 8.10.2020 16:00
 */
public class LombokTest {

    @Test
    public void testLombok() {
        Gift gift = Gift.builder().description("desc").name("myGift").id(1).price(12).build();
        System.out.println(gift.toString());
    }
}
