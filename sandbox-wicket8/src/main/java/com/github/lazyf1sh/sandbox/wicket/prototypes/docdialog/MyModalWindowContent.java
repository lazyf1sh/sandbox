package com.github.lazyf1sh.sandbox.wicket.prototypes.docdialog;

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

        Form<?> form = new Form<>("myForm");
        add(form);

        AjaxSubmitLink saveAndCloseBtn = new AjaxSubmitLink("saveAndCloseBtn", form)
        {
            private static final long serialVersionUID = 1079394286186679880L;

            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                super.onSubmit(target);
            }
        };

        AjaxSubmitLink saveBtn = new AjaxSubmitLink("saveBtn", form)
        {
            private static final long serialVersionUID = 1079394286186679880L;

            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                super.onSubmit(target);
            }
        };

        AjaxSubmitLink cancelBtn = new AjaxSubmitLink("cancelBtn", form)
        {
            private static final long serialVersionUID = 1079394286186679880L;

            @Override
            protected void onSubmit(final AjaxRequestTarget target)
            {
                super.onSubmit(target);
            }
        };

        controlButtonContainer.add(saveAndCloseBtn, cancelBtn, saveBtn);
        add(controlButtonContainer);

    }
}
