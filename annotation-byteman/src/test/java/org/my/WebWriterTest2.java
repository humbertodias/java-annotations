package org.my;

import org.jboss.byteman.contrib.bmunit.BMRule;
import org.jboss.byteman.contrib.bmunit.BMScript;
import org.jboss.byteman.contrib.bmunit.BMUnitConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.io.PrintStream;

/**
 * simple unit test class for WebWriter app
 */
// https://github.com/adinn/bmunit-tutorial
@RunWith(org.jboss.byteman.contrib.bmunit.BMUnitRunner.class)
@BMUnitConfig(loadDirectory="target/test-classes")
@BMScript(value="check.btm")
public class WebWriterTest2
{
    @Test
    @BMRule(name = "handle file not found",
            targetClass = "FileOutputStream",
            targetMethod = "<init>(File)",
            action = "throw new FileNotFoundException( \"Ha ha Byteman fooled you again!\" )"
    )
    public void handleFileNotFound()
    {
        System.out.println("-------- handleFileNotFound ---------");
        WebWriter writer = new WebWriter("foo.html", "Andrew");
        PrintStream ps = writer.openFile();
        Assert.assertTrue(ps == null);
        System.out.println("-------- handleFileNotFound ---------\n");
    }

    @Test
    @BMRule(name = "test write body",
            targetClass = "FileOutputStream",
            targetMethod = "write(byte[],int,int)",
            condition = "incrementCounter($0) == 2",
            action = "throw new java.io.IOException( \"Ha ha Byteman fooled you!\" )"
    )
    public void testWriteBody()
    {
        System.out.println("-------- testWriteBody ---------");
        WebWriter writer = new WebWriter("foo.html", "Andrew");
        PrintStream ps = writer.openFile();
        boolean result = writer.writeHeader(ps);
        Assert.assertTrue(result);
        result = writer.writeBody(ps);
        ps.close();
        Assert.assertFalse(result);
        System.out.println("-------- testWriteBody ---------\n");
    }
}