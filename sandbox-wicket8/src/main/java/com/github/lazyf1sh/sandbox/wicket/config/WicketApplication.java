package com.github.lazyf1sh.sandbox.wicket.config;

import com.github.lazyf1sh.sandbox.wicket.examples.pages.Index;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication
{
    public Class<? extends Page> getHomePage()
    {
        return Index.class;
    }
}
