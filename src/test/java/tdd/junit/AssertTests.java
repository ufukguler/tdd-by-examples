package tdd.junit;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * created by: ufuk on 8.10.2020 13:25
 */
public class AssertTests {

    @Test
    public void testAssertions() {
        Dummy d1 = new Dummy(1);
        Dummy d2 = new Dummy(1);
        Assert.assertEquals(d1, d2);
    }

    @Test
    public void assertSame() {
        Dummy d1 = new Dummy(1);
        Dummy d2 = d1;
        Assert.assertSame("d1 should be equal to d2", d1, d2);
    }

    @Test
    public void assertNull() {
        Dummy d2 = null;
        Assert.assertNull(d2);
    }

    @Test
    public void assertNotNull() {
        Dummy d1 = new Dummy(1);
        Assert.assertNotNull(d1);
    }

    @Test
    public void assertTrue() {
        Dummy d1 = new Dummy(1);
        Dummy d2 = d1;
        Assert.assertTrue(d1.equals(d2));
    }

    @Test
    public void assertArrayEquals() {
        String[] arr1 = new String[]{"a", "b"};
        String[] arr2 = new String[]{"a", "b"};

        // checks both lengths and characters
        Assert.assertArrayEquals(arr1, arr2);
    }

    private static class Dummy {
        private int id;

        public Dummy(int id) {
            this.id = id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Dummy{ id=" + id + " }";
        }

        @Override
        public boolean equals(Object o) {
            return this.id == ((Dummy) o).getId();
        }
    }
}
