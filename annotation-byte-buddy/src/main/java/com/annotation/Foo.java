package com.annotation;

public class Foo {

    public String sayHelloFoo() {
        return "Hello in Foo!";
    }

    @MyAnnotation
    public String sayHelloAnnotated(String msg){
        return "Annotaded " + msg;
    }
}
