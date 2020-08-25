package com.github.lazyf1sh.sandbox.wicket.examples.nestedthings.dialogs;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

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

        add(new AjaxLink<String>("closeDialogs", Model.of("qwe"))
        {
            private static final long serialVersionUID = 1312312312321L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                onCloseNested2(target);
            }
        });
    }

    public abstract void onCloseNested2(AjaxRequestTarget target);
}
