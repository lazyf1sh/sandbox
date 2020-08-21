package com.github.lazyf1sh.sandbox.wicket.prototypes.docdialog;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;


public class MyPageWithModalWindow extends WebPage
{
    private static final long          serialVersionUID = -4348869317433578819L;
    private              MyModalWindow modalWindow      = new MyModalWindow("myModalWindow");

    @Override
    protected void onInitialize()
    {
        super.onInitialize();
        add(modalWindow);
        add(new AjaxLink<String>("someButton", Model.of("213"))
        {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                modalWindow.show(target);
            }
        });


    }
}
