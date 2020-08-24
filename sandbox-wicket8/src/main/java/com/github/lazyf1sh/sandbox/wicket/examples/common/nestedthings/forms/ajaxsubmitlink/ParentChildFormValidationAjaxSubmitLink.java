package com.github.lazyf1sh.sandbox.wicket.examples.common.nestedthings.forms.ajaxsubmitlink;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;

/**
 * @author Ivan Kopylov
 */
public class ParentChildFormValidationAjaxSubmitLink extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        ModalWindow parentWindow = new ModalWindow("parentWindow");
        add(parentWindow);
        add(buildShowParentWin(parentWindow));

        ModalWindow nestedWindow = new ModalWindow("nestedWindow");
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
                System.out.println("showParentWindow - onClick.");
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
                System.out.println("showParentWindow - onClick.");
                window.setContent(new NestedPanel(window.getContentId(), null));
                window.show(target);
            }
        };
    }
}
