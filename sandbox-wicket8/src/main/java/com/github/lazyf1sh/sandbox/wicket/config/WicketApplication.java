package com.github.lazyf1sh.sandbox.wicket.config;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import com.github.lazyf1sh.sandbox.wicket.examples.pages.IndexPage;

public class WicketApplication extends WebApplication
{
    public Class<? extends Page> getHomePage()
    {
        return IndexPage.class;
    }
}
