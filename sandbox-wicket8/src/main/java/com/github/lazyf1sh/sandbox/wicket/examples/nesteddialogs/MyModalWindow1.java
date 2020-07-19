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

        ModalWindow nestedModalWindow = new ModalWindow("nestedModalWindow");
        nestedModalWindow.setContent(new MyModalWindow2(nestedModalWindow.getContentId())
        {
            @Override
            public void onCloseNested2(AjaxRequestTarget target)
            {
                MyModalWindow1.this.onCloseNested2(target);
                nestedModalWindow.close(target);
            }
        });
        add(nestedModalWindow);

        add(new AjaxLink<Void>("showNestedModalWindow")
        {
            private static final long serialVersionUID = 1312321L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                nestedModalWindow.show(target);
            }
        });
    }

    public abstract void onCloseNested2(AjaxRequestTarget target);
}
