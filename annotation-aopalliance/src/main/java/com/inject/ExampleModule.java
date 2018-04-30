package com.inject;

import static com.google.inject.matcher.Matchers.*;

import com.annotation.VideoRental;
import com.annotation.inspector.TracingInterceptor;
import com.google.inject.AbstractModule;

public class ExampleModule extends AbstractModule {

    public void configure() {
        bindInterceptor(
                subclassesOf(VideoRental.class),
                any(),
                new TracingInterceptor());
    }
}