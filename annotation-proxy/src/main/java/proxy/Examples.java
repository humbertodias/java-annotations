package proxy;

public interface Examples {
    @Clocking
    String thisIsAMethod();

    String thisIsAnotherMethod(String something);

    @Clocking
    String thisIsALongRunningMethod();
}