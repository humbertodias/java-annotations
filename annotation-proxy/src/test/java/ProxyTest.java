import org.junit.Test;
import proxy.Examples;
import proxy.ExamplesFactory;

import static org.junit.Assert.assertEquals;

public class ProxyTest {

    @Test
    public void myTest(){
        Examples examples = ExamplesFactory.getExamples();
        assertEquals("thisIsAMethod called!",examples.thisIsAMethod());
        assertEquals("thisIsAnotherMethod called!",examples.thisIsAnotherMethod(""));
        assertEquals("thisIsALongRunningMethod called!",examples.thisIsALongRunningMethod());

    }
}
