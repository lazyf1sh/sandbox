package com.github.lazyf1sh.sandbox.wicket.examples.common.nestedthings.forms.ajaxsubmitlink;

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
    private TextField<String> parentTextField;
    private ModalWindow       nestedWindow;

    public ParentPanel(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Form<?> parentForm = buildForm();
        add(parentForm);

        parentTextField = buildTextField();
        parentForm.add(parentTextField);

        nestedWindow = new ModalWindow("nestedWindow");
        nestedWindow.setContent(new NestedPanel(nestedWindow.getContentId(), parentForm));
        parentForm.add(nestedWindow);

        parentForm.add(buildShowNestedWindow());
        parentForm.add(buildSaveButton(parentForm));
    }

    private AjaxLink<Void> buildShowNestedWindow()
    {
        return new AjaxLink<Void>("showNestedWindow")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                System.out.println("showNestedWindow - onClick.");
                nestedWindow.show(target);
            }
        };
    }

    private AjaxButton buildSaveButton(Form<?> parentForm)
    {
        return new AjaxButton("parentSaveButton", parentForm)
        {
            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                System.out.println("parentSaveButton - onSubmit.");
                super.onSubmit(target);
            }

            @Override
            protected void onBeforeRender()
            {
                System.out.println("parentSaveButton - onBeforeRender.");
                super.onBeforeRender();
            }

            @Override
            protected void onModelChanging()
            {
                System.out.println("parentSaveButton - onModelChanging.");
                super.onModelChanging();
            }

            @Override
            protected void onModelChanged()
            {
                System.out.println("parentSaveButton - onModelChanged.");
                super.onModelChanged();
            }
        };
    }

    private TextField<String> buildTextField()
    {
        return new TextField<String>("parentTextField", Model.of("parent text field value"))
        {
            @Override
            protected void onBeforeRender()
            {
                System.out.println("parentTextField - onBeforeRender.");
                super.onBeforeRender();
            }

            @Override
            protected void onModelChanging()
            {
                System.out.println("parentTextField - onModelChanging.");
                super.onModelChanging();
            }

            @Override
            protected void onModelChanged()
            {
                System.out.println("parentTextField - onModelChanged.");
                super.onModelChanged();
            }
        };
    }

    private Form<?> buildForm()
    {
        return new Form<Void>("parentForm")
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
                System.out.println("parentForm - onSubmit. textField model object: " + parentTextField.getModelObject());
                super.onSubmit();
            }
        };
    }
}
