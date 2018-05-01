package proxy;

import java.lang.reflect.Proxy;

public class ExamplesFactory {

    public static Examples getExamples(){
        Examples examples = (Examples) Proxy.newProxyInstance(Examples.class.getClassLoader(), new Class[]{Examples.class}, new ExamplesInvocationHandler());
        return examples;
    }

}
