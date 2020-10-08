package tdd.assertJ;

import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * created by: ufuk on 8.10.2020 16:34
 */
public class AssertJListTest1 {

    public final String text = "ufuk";
    public final List<String> citiesTr0 = new ArrayList<>(Arrays.asList("istanbul", "ankara", "izmir"));
    public final List<String> citiesTr1 = new ArrayList<>(Arrays.asList("istanbul", "ankara", "izmir"));
    public final List<String> citiesTr2 = new ArrayList<>(Arrays.asList("istanbul", "ankara", "izmir", "bursa", "antalya"));
    public final List<String> citiesInEurope = new ArrayList<>(Arrays.asList("london", "munich", "paris"));
    public final List<String> cities = new ArrayList<>(Arrays.asList("istanbul", "ankara", "izmir", "london", "munich", "paris"));

    @Test
    public void testCitiesList() {
        assertThat(citiesTr1)
                .describedAs("error message goes here")
                .contains("ankara")
                .doesNotContain("bursa")
                .containsExactly("istanbul", "ankara", "izmir")
                .doesNotHaveDuplicates();
    }

    /**
     * checks the condition that I have defined as citiesInTurkey()
     */
    @Test
    public void testCitiesInTurkey() {
        assertThat(citiesTr0)
                .describedAs("error message goes here")
                .have(citiesInTurkey());
    }

    /**
     * checks the condition that I have defined as citiesInTurkey()
     * at lease X cities of citiesInTurkey() should be an element of citiesTr2
     */
    @Test
    public void testCitiesInTurkey2() {
        assertThat(citiesTr2)
                .describedAs("error message goes here")
                .haveAtLeast(2, citiesInTurkey());
    }

    /**
     * condition for testCitiesInTurkey()
     *
     * @return
     */
    private Condition<? super String> citiesInTurkey() {
        return new Condition<>() {
            @Override
            public boolean matches(String value) {
                return citiesTr1.contains(value);
            }
        };
    }

    /**
     * checks the condition that I have defined as citiesInEurope()
     */
    @Test
    public void testCitiesInEurope() {
        assertThat(citiesInEurope)
                .describedAs("error message goes here")
                .have(citiesInEurope());
    }

    /**
     * condition for testCitiesInEurope()
     *
     * @return
     */
    private Condition<? super String> citiesInEurope() {
        return new Condition<>() {
            @Override
            public boolean matches(String value) {
                return citiesInEurope.contains(value);
            }
        };
    }

    /**
     * checks multiple conditions
     * must be -> 3 cities from turkey, 3 cities from europe
     */
    @Test
    public void testCities() {
        assertThat(cities)
                .describedAs("error message goes here")
                .haveExactly(3, citiesInTurkey())
                .haveExactly(3, citiesInEurope());
    }


    @Test
    public void testString() {
        assertThat(text)
                .describedAs("error message goes here ")
                .isEqualTo("ufuk")
                .startsWith("u")
                .endsWith("k")
                .contains("f")
                .isNotBlank()
                .isNotEmpty()
                .doesNotContain("a")
                .containsOnlyOnce("f");
    }

}
