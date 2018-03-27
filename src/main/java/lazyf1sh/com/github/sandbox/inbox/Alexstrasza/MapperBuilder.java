package Alexstrasza;

import org.dozer.loader.api.BeanMappingBuilder;

public class MapperBuilder extends BeanMappingBuilder {
    @Override
    protected void configure() {
            mapping(A.class, B.class).fields("qwerty", "qwerty2");
    }
}
