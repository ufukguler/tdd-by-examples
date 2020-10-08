package tdd.assertJ;

import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.*;

/**
 * created by: ufuk on 8.10.2020 18:03
 */
public class FileTest {
    File file = new File("src/main/resources/test.txt");

    @Test
    public void testFile() {
        assertThat(file)
                .exists()
                .canRead()
                .canWrite()
                .hasExtension("txt")
                .hasName("test.txt");

        assertThat(contentOf(file)
                .startsWith("Lorem"));
    }
    @Test
    public void testException(){
        Exception exception = new Exception("test");
        assertThat(exception)
                .hasMessage("test")
                .isInstanceOf(Exception.class)
                .hasMessageContaining("t");
    }
}
