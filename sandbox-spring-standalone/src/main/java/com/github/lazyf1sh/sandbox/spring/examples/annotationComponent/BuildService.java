package com.github.lazyf1sh.sandbox.spring.examples.annotationComponent;

import org.springframework.stereotype.Component;

/**
 * Annotation @Component has the same effect as @Service. Both annotations are instructing Spring that the annotated class
 * is a candidate for autodetection using annotation-based configuration and classpath scanning. However, since
 * the InjectSimpleConfig class is storing the application configuration, rather than providing a business service,
 * using @Component makes more sense. Practically, @Service is a specialization of @Component, which indicates
 * that the annotated class is providing a business service to other layers within the application. (c) Pro Spring 5, 5th Edition
 */
@Component
public class BuildService
{
    public String build()
    {
        return "something";
    }
}
