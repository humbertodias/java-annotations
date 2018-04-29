package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

public class ExamplesInvocationHandler implements InvocationHandler {
    // ******************************
    // Fields
    // ******************************
    private Examples examples = new ExamplesImpl();

    // ******************************
    // Public methods
    // ******************************
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // If the annotation is not present, just redirect the method call to its origin...
        if(!method.isAnnotationPresent(Clocking.class)) {
            return method.invoke(examples, args);
        }

        // ... otherwise log the execution time of it.
        Instant start = Instant.now();
        Object returnObj = method.invoke(examples, args);
        Instant end = Instant.now();

        // TODO: This is for demonstration purpose only and should use the application's logging system.
        System.out.println("Method " + method.getName() + " executed in " + Duration.between(end, start) + ".");

        return returnObj;
    }


}