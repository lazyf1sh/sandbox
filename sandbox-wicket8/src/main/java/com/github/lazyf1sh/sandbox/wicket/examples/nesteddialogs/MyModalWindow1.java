package com.github.lazyf1sh.sandbox.wicket.examples.nesteddialogs;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * @author Ivan Kopylov
 */
public abstract class MyModalWindow1 extends Panel
{
    public MyModalWindow1(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        ModalWindow modalWindow = new ModalWindow("nestedModalWindow");
        modalWindow.setContent(new MyModalWindow2(modalWindow.getContentId())
        {
            @Override
            public void onClose(AjaxRequestTarget target)
            {
//                modalWindow.close(target);
            }
        });
        add(modalWindow);

        add(new AjaxLink<Void>("showNestedModalWindow")
        {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                modalWindow.show(target);
                onShowNested(target);
            }
        });
    }

    public abstract void onShowNested(AjaxRequestTarget target);
}
