package tdd.assertJ;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * created by: ufuk on 8.10.2020 17:23
 */
public class AssertJListTest {

    /**
     * extracting, generates a list by taking every field name in an item
     */
    @Test
    public void testList() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", 1));
        items.add(new Item("item2", 2));
        items.add(new Item("item3", 3));
        items.add(new Item("item4", 4));

        assertThat(items)
                .extracting("name")
                .contains("item1", "item2");

        assertThat(items)
                .extracting("name", "id")
                .contains(
                        tuple("item1", 1),
                        tuple("item2", 2)
                );
        assertThat(extractProperty("id", Integer.class)
                .from(items))
                .contains(1,2,3)
                .containsExactly(1,2,3,4);
    }

    @Data
    @AllArgsConstructor
    static class Item {
        private String name;
        private int id;
    }
}
