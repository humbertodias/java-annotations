package org.my;

import org.jboss.byteman.contrib.bmunit.BMScript;
import org.jboss.byteman.contrib.bmunit.BMUnitConfig;
import org.junit.Test;
import org.junit.runner.RunWith;

// https://developer.jboss.org/wiki/BMUnitUsingBytemanWithJUnitOrTestNGFromMavenAndAnt
@RunWith(org.jboss.byteman.contrib.bmunit.BMUnitRunner.class)
@BMUnitConfig(loadDirectory="target/test-classes")
@BMScript(value="check.btm")
public class WebWriterTest {

    @Test
    public void testWriteHead()
    {

        System.out.println("-------- testWriteHead ---------");
        WebWriter writer = new WebWriter("foo.html", "Andrew");
        writer.writeHeader(System.out);
        System.out.println("-------- testWriteHead ---------\n");

    }
}
