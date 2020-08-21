package com.github.lazyf1sh.sandbox.wicket.examples.common.nestedthings.forms;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;

/**
 * @author Ivan Kopylov
 */
public class ParentChildFormValidationExample extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        ModalWindow parentWindow = new ModalWindow("parentWindow");
        parentWindow.setContent(new ParentPanel(parentWindow.getContentId()));
        add(parentWindow);

        add(new AjaxLink<Void>("showParentWindow")
        {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                parentWindow.show(target);
            }
        });
    }
}
