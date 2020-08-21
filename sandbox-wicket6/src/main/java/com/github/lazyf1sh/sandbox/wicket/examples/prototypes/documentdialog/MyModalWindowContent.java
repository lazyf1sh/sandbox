package com.github.lazyf1sh.sandbox.wicket.examples.prototypes.documentdialog;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;

public class MyModalWindowContent extends Panel
{
    private static final long serialVersionUID = 5609396783783385769L;

    public MyModalWindowContent(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        WebMarkupContainer controlButtonContainer = new WebMarkupContainer("controlElementsContainer");

        Form<?> form = new Form<Void>("myForm");
        add(form);

        AjaxSubmitLink saveAndCloseBtn = new AjaxSubmitLink("saveAndCloseBtn", form)
        {
            private static final long serialVersionUID = 1079394286186679880L;

            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form)
            {
                super.onSubmit(target, form);
            }
        };

        AjaxSubmitLink saveBtn = new AjaxSubmitLink("saveBtn", form)
        {
            private static final long serialVersionUID = 1079394286186679880L;

            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form)
            {
                super.onSubmit(target, form);
            }
        };

        AjaxSubmitLink cancelBtn = new AjaxSubmitLink("cancelBtn", form)
        {
            private static final long serialVersionUID = 1079394286186679880L;

            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form)
            {
                super.onSubmit(target, form);
            }
        };

        controlButtonContainer.add(saveAndCloseBtn, cancelBtn, saveBtn);
        add(controlButtonContainer);

    }
}
