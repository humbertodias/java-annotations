package org.my;

public class AppMain2
{
    // java -cp target/classes/ -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=script:src/main/resources/thread.btm,boot:${BYTEMAN_HOME}/lib/byteman.jar -Dorg.jboss.byteman.transform.all org.my.AppMain2 foo bar baz
    public static void main(String[] args)
    {

        for (int i = 0; i < args.length; i++) {

            final String arg = args[i];

            Thread thread = new Thread(arg) {

                public void run() {

                    System.out.println(arg);

                }

            };

            thread.start();

            try {

                thread.join();

            } catch (Exception e) {

            }

        }

    }

}