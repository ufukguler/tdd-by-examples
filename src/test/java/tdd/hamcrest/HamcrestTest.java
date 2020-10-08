package tdd.hamcrest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * created by: ufuk on 8.10.2020 15:47
 */
public class HamcrestTest {
    String text1 = "ufuk";
    String text2 = null;

    @Test
    public void testList() {
        List<String> cities = new ArrayList<>(Arrays.asList("istanbul", "ankara", "izmir"));
        assertThat(cities, hasItem("istanbul"));
        assertThat(cities, hasItems("istanbul", "izmir"));

        // allOf -  && .. && .. &&
        assertThat(cities, allOf(hasItem("istanbul"), not(hasItem("bursa"))));

        // either -  || .. || .. ||
        assertThat(cities, either(hasItem("istanbul")).or(hasItem("bursa")));
    }


    @Test
    public void test() {
        assertEquals("ufuk", text1);
        assertThat(text1, is(equalTo("ufuk")));
        assertThat(text2, is(nullValue()));
        assertThat(text1, is(notNullValue()));
        assertThat(text1, containsString("fu"));
        assertThat(text1, anyOf(containsString("fu"), is(notNullValue())));
    }
}
