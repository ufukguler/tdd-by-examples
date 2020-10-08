package tdd.mock;

import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * created by: ufuk on 8.10.2020 20:48
 * in order to use Spy we need a real object
 */

public class SpyTest {

    @Test(expected = Exception.class)
    public void testSpy() {
        DummyServiceImpl dummyService = spy(new DummyServiceImpl());

        dummyService.add("pigeon");
        dummyService.remove("pigeon");
        dummyService.update("pigeon");

        doThrow(new Exception("something just came up")).when(dummyService).add("covid-19");
        // spy already uses the real methods, so there is no point in using doCallRealMethod
        doCallRealMethod().when(dummyService).add("vulture");

        // after this line nothing will happen when we use the add() method
        doNothing().when(dummyService).add(anyString());
        dummyService.add("pigeon");

    }
}
