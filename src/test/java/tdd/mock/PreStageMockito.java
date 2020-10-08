package tdd.mock;

import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * created by: ufuk on 8.10.2020 20:32
 */

/**
 * when, then can be used with method that has a return type
 */
public class PreStageMockito {

    @Test(expected = Exception.class)
    public void testWhen() {
        DummyService service = mock(DummyService.class);

        when(service.get(eq("pigeon"))).thenReturn("pigeon");
        when(service.get(eq("vulture"))).thenThrow(new Exception());
    }


    @Test
    public void doTests() {
        DummyService service = mock(DummyService.class);

        doNothing().when(service).add(anyString());
        doNothing().when(service).remove(anyString());
        doNothing().when(service).update(anyString());

        doReturn("vulture").when(service).get("pigeon");
    }
}
