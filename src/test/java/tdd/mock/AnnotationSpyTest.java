package tdd.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * created by: ufuk on 8.10.2020 21:21
 */

@RunWith(MockitoJUnitRunner.class)
public class AnnotationSpyTest {

    @Spy
    private DummyServiceImpl dummyService;

    @Test
    public void test() {
        dummyService.add("pigeon");
    }
}
