package com.github.lazyf1sh.sandbox.wicket.examples.common.nestedthings.forms;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 * @author Ivan Kopylov
 */
public class ParentPanel extends Panel
{
    public ParentPanel(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Form<?> parentForm = new Form<Void>("parentForm")
        {
            @Override
            protected boolean wantSubmitOnNestedFormSubmit()
            {
                //try to switch flag
                return true;//wicket will iterate over parent components also and validate them
                //also, place a breakpoint to FormComponent.validate and check what components are validated
            }

            @Override
            protected void onSubmit()
            {
                System.out.println("parentForm - onSubmit");
                super.onSubmit();
            }
        };
        add(parentForm);

        TextField<String> parentTextField = new TextField<String>("parentTextField", Model.of("textField1"))
        {
            @Override
            protected void onBeforeRender()
            {
                System.out.println("parentTextField - onBeforeRender");
                super.onBeforeRender();
            }

            @Override
            protected void onModelChanging()
            {
                System.out.println("parentTextField - onModelChanging");
                super.onModelChanging();
            }

            @Override
            protected void onModelChanged()
            {
                System.out.println("parentTextField - onModelChanged");
                super.onModelChanged();
            }
        };
        parentForm.add(parentTextField);

        ModalWindow nestedWindow = new ModalWindow("nestedWindow");
        nestedWindow.setContent(new NestedPanel(nestedWindow.getContentId()));
        parentForm.add(nestedWindow);

        parentForm.add(new AjaxLink<Void>("showNestedWindow")
        {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                nestedWindow.show(target);
            }
        });

        parentForm.add(new AjaxButton("parentSaveButton", parentForm)
        {
            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                parentForm.findSubmittingButton().onSubmit();
                System.out.println("parentSaveButton - onSubmit");
                super.onSubmit(target);
            }

            @Override
            protected void onBeforeRender()
            {
                System.out.println("parentSaveButton - onBeforeRender");
                super.onBeforeRender();
            }

            @Override
            protected void onModelChanging()
            {
                System.out.println("parentSaveButton - onModelChanging");
                super.onModelChanging();
            }

            @Override
            protected void onModelChanged()
            {
                System.out.println("parentSaveButton - onModelChanged");
                super.onModelChanged();
            }
        });
    }
}
