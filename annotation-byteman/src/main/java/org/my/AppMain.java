package org.my;

public class AppMain
{
    // java -cp target/classes/ -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:src/main/resources/appmain.btm org.my.AppMain foo bar baz
    public static void main(String[] args)
    {

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);

        }

    }

}
