package com.github.lazyf1sh.sandbox.java.dozermapper;

import com.github.lazyf1sh.sandbox.java.dozermapper.conf.DozerMapper;
import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case2.From;
import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case2.Inner;
import com.github.lazyf1sh.sandbox.java.dozermapper.domain.case2.To;
import org.dozer.Mapper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class MapObjectToString
{
    private Mapper MAPPER  = DozerMapper.getInstance();

    @Test
    public void run()
    {
        Inner inner = new Inner();
        From from = new From();
        from.setInner(inner);

        To map = MAPPER.map(from, To.class);
        Assert.assertEquals(Inner.value, map.getReceiver());
    }
}
