package com.github.lazyf1sh.sandbox.wicket.examples.nesteddialogs;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * @author Ivan Kopylov
 */
public abstract class MyModalWindow2 extends Panel
{
    public MyModalWindow2(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        add(new AjaxLink<Void>("closeDialogs")
        {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                onClose(target);
            }
        });
    }

    public abstract void onClose(AjaxRequestTarget target);
}
