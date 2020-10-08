package tdd.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * created by: ufuk on 8.10.2020 21:16
 */

@RunWith(MockitoJUnitRunner.class)
public class AnnotationMockTest {

    /**
     * with the mock annotation we dont need to use ->  service = Mockito.mock(DummyService.class)
     */
    @Mock
    private DummyService dummyService;


    @Test
    public void test() {
        dummyService.add("pigeon");
    }
}
