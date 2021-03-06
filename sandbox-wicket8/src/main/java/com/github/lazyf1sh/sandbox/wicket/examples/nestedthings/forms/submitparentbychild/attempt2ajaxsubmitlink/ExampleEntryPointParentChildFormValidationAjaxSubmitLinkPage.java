package com.github.lazyf1sh.sandbox.wicket.examples.nestedthings.forms.submitparentbychild.attempt2ajaxsubmitlink;

import com.github.lazyf1sh.sandbox.wicket.util.Util;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;

/**
 * @author Ivan Kopylov
 */
public class ExampleEntryPointParentChildFormValidationAjaxSubmitLinkPage extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        ModalWindow parentWindow = new ModalWindow("parentWindow");
        parentWindow.setTitle("Parent window");
        add(parentWindow);
        add(buildShowParentWin(parentWindow));

        ModalWindow nestedWindow = new ModalWindow("nestedWindow");
        nestedWindow.setTitle("Nested window");
        add(nestedWindow);
        add(buildShowNestedWindow(nestedWindow));
    }

    private AjaxLink<Void> buildShowParentWin(ModalWindow window)
    {
        return new AjaxLink<Void>("showParentWindow")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                Util.showComponentMessage(this);
                window.setContent(new ParentPanel(window.getContentId()));
                window.show(target);
            }
        };
    }

    private AjaxLink<Void> buildShowNestedWindow(ModalWindow window)
    {
        return new AjaxLink<Void>("showNestedWindow")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                Util.showComponentMessage(this);
                window.setContent(new NestedPanel(window.getContentId(), null));
                window.show(target);
            }
        };
    }
}
