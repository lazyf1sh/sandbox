package com.github.lazyf1sh.sandbox.spring.examples.genericBeanType;

import org.springframework.stereotype.Service;

/**
 * Spring 4.0 as it will automatically consider generics as a form of @Qualifier.
 *
 * @author Ivan Kopylov
 * @see <a href=https://stackoverflow.com/questions/22603291/how-to-autowire-bean-of-generic-type-t-in-spring>https://stackoverflow.com/questions/22603291/how-to-autowire-bean-of-generic-type-t-in-spring</a>
 */
@Service
public class GenericsAsQualifierExample
{
    private final GenericService<Event> eventGenericService; // Injects the EventService bean
    private final GenericService<User>  userGenericService; // Injects the UserService bean

    public GenericsAsQualifierExample(final GenericService<Event> eventGenericService, final GenericService<User> userGenericService)
    {
        this.eventGenericService = eventGenericService;
        this.userGenericService = userGenericService;
    }

    public void run()
    {
        eventGenericService.genericMethod();
        userGenericService.genericMethod();
    }
}
