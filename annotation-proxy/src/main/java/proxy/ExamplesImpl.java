package proxy;

// ******************************
// Inner classes
// ******************************
class ExamplesImpl implements Examples {
    @Override
    public void thisIsAMethod() {
        System.out.println("thisIsAMethod called!");
    }

    @Override
    public void thisIsAnotherMethod(String something) {
        System.out.println("thisIsAnotherMethod called!");
    }

    @Override
    public void thisIsALongRunningMethod() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thisIsALongRunningMethod called!");
    }
}