package com.github.lazyf1sh.sandbox.wicket.examples.nested.forms;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IFormSubmitter;
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
                return false;//wicket will iterate over parent components also and validate them
                //also, place a breakpoint to FormComponent.validate and check what components are validated
            }
        };
        add(parentForm);

        TextField<String> textFieldParent = new TextField<String>("textFieldParent", Model.of("textField1"))
        {
            @Override
            protected void onBeforeRender()
            {
                System.out.println("textFieldParent - onBeforeRender");
                super.onBeforeRender();
            }

            @Override
            protected void onModelChanging()
            {
                System.out.println("textFieldParent - onModelChanging");
                super.onModelChanging();
            }

            @Override
            protected void onModelChanged()
            {
                System.out.println("textFieldParent - onModelChanged");
                super.onModelChanged();
            }
        };
        parentForm.add(textFieldParent);

        ModalWindow parentWindow = new ModalWindow("nestedWindow");
        parentWindow.setContent(new NestedPanel(parentWindow.getContentId())
        {
        });
        parentForm.add(parentWindow);

        parentForm.add(new AjaxLink<Void>("showNestedWindow")
        {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                parentWindow.show(target);
            }
        });

        parentForm.add(new AjaxButton("saveButtonParent", parentForm)
        {
            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                super.onSubmit(target);
            }
        });
    }
}
