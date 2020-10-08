package tdd.mock;

import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

/**
 * created by: ufuk on 8.10.2020 19:50
 */

public class MockTest {
    @Test
    public void test() {
        DummyService dummyService = mock(DummyService.class);
        dummyService.add("pigeon");
        dummyService.add("sparrow");

        verify(dummyService).add("pigeon");
        verify(dummyService).add("sparrow");
    }

    @Test
    public void testimes() {
        DummyService dummyService = mock(DummyService.class);
        dummyService.add("sparrow");
        dummyService.add("sparrow");
        dummyService.add("sparrow");
        dummyService.add("pigeon");

        // how many times add method called with the exact parameter
        verify(dummyService, times(3)).add("sparrow");
        verify(dummyService, times(1)).add("pigeon");

        // verify that delete method never invoked before
        verify(dummyService, never()).remove(anyString());

        // verify that add method at least called 2 times
        verify(dummyService, atLeast(2)).add("sparrow");

    }

    /**
     * checks the methods invoke order
     */
    @Test
    public void order() {
        DummyService dummyService = mock(DummyService.class);
        dummyService.add("sparrow");
        dummyService.add("pigeon");
        dummyService.add("vulture");

        InOrder inOrder = inOrder(dummyService);

        inOrder.verify(dummyService).add("sparrow");
        inOrder.verify(dummyService).add("pigeon");
        inOrder.verify(dummyService).add("vulture");
    }

    /**
     * no more method will be invoked
     * after verifying the methods that are already invoked
     */
    @Test
    public void noMoreInteraction() {
        DummyService dummyService = mock(DummyService.class);
        dummyService.add("sparrow");
        dummyService.remove("pigeon");

        // verify the add & remove methods are invoked
        verify(dummyService).add("sparrow");
        verify(dummyService).remove("pigeon");

        verifyNoMoreInteractions(dummyService);
    }

    /**
     * no interaction with the given mock
     */
    @Test
    public void zeroInteraction() {
        DummyService dummyService = mock(DummyService.class);
        verifyZeroInteractions(dummyService);
    }

}
