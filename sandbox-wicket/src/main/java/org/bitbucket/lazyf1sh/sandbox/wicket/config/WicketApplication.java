package org.bitbucket.lazyf1sh.sandbox.wicket.config;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.bitbucket.lazyf1sh.sandbox.wicket.examples.pages.AjaxEventBehaviorPreconditionExample;

public class WicketApplication extends WebApplication
{
    public Class<? extends Page> getHomePage()
    {
        return AjaxEventBehaviorPreconditionExample.class;
    }
}
