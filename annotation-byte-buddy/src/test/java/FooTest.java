import com.annotation.Bar;
import com.annotation.Foo;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import org.junit.Test;

import static net.bytebuddy.matcher.ElementMatchers.isDeclaredBy;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static net.bytebuddy.matcher.ElementMatchers.returns;
import static org.junit.Assert.assertEquals;

public class FooTest {

    @Test
    public void runtimeInterceptTest() throws IllegalAccessException, InstantiationException {
        Bar bar = new Bar();
        String r = new ByteBuddy()
                .subclass(Foo.class)
                .method(named("sayHelloFoo")
                        .and(isDeclaredBy(Foo.class)
                                .and(returns(String.class))))
                .intercept(MethodDelegation.to(bar))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance()
                .sayHelloFoo();
        assertEquals(r, bar.sayHelloBar());
    }

    @Test
    public void agentLoadedInterceptTest() {

        ByteBuddyAgent.install();
        new ByteBuddy()
                .redefine(Foo.class)
                .method(named("sayHelloFoo"))
                .intercept(FixedValue.value("Hello Foo Redefined"))
                .make()
                .load(
                        Foo.class.getClassLoader(),
                        ClassReloadingStrategy.fromInstalledAgent());

        Foo f = new Foo();

        assertEquals(f.sayHelloFoo(), "Hello Foo Redefined");

    }


}
