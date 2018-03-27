package Alexstrasza;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class DozerMapperExperiments {
    public static void main(String[] args) {

        List<C> list = new ArrayList<C>();

        A a = new A();
        a.setName("123");
        a.setC(new C("title1", 1));
        a.setQwerty("qwerty");

        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(new MapperBuilder());
        B b = mapper.map(a, B.class);
        b.getC();
        int i = 0;
    }
}
