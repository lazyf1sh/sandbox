package com.github.lazyf1sh.sandbox.wicket.config;

import com.github.lazyf1sh.sandbox.wicket.examples.pages.baisc.PageOne;
import com.github.lazyf1sh.sandbox.wicket.examples.pages.chartupdater.MyWebsocketResource;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication
{
    public Class<? extends Page> getHomePage()
    {
        return PageOne.class;
    }

    @Override
    protected void init()
    {
        super.init();

        getSharedResources().add(MyWebsocketResource.class.getName(), new MyWebsocketResource());
    }
}
