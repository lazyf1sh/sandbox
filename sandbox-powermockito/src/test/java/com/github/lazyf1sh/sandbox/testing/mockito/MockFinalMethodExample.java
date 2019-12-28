package com.github.lazyf1sh.sandbox.testing.mockito;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.github.lazyf1sh.sandbox.testing.mockito.domain.Bottle;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Bottle.class)
public class MockFinalMethodExample
{
    @Test
    public void mockfinal()
    {
        Bottle bottle = PowerMockito.mock(Bottle.class);
        PowerMockito.when(bottle.getBottle()).thenReturn("cup");


        Assert.assertEquals("cup", bottle.getBottle());
    }
}
