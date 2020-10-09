package com.github.lazyf1sh.sandbox.wicket.examples.js;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnLoadHeaderItem;
import org.apache.wicket.markup.html.panel.Panel;

public class JsRenderOnLoadHeaderItemPanel extends Panel
{
    public JsRenderOnLoadHeaderItemPanel(String id)
    {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response)
    {
        super.renderHead(response);
        response.render(new OnLoadHeaderItem("alert('OnLoadHeaderItem - subpanel.')"));
    }
}
