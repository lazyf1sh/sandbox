package com.github.lazyf1sh.sandbox.wicket.examples.common.nestedthings.forms.ajaxsubmitlink;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 * @author Ivan Kopylov
 */
public class NestedPanel extends Panel
{
    private final Form<?>           injectedForm;
    private       TextField<String> nestedTextField;

    public NestedPanel(String id, Form<?> form)
    {
        super(id);
        this.injectedForm = form;
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        nestedTextField = buildNestedTextField();
        add(nestedTextField);
        if (injectedForm != null)
        {
            add(buildNestedSaveButtonAjaxSubmitLink());
        }
        else
        {
            add(buildNestedSaveButtonAjaxLink());
        }

    }

    private AjaxSubmitLink buildNestedSaveButtonAjaxSubmitLink()
    {
        return new AjaxSubmitLink("nestedSaveButton", injectedForm)
        {
            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                String msg = String.format("parentForm - onSubmit. parentTextField model object: %s | convertedInput: %s", nestedTextField.getModelObject(), nestedTextField.getConvertedInput());
                System.out.println(msg);
                super.onSubmit(target);
            }

            @Override
            protected void onBeforeRender()
            {
                System.out.println("nestedSaveButton - onBeforeRender.");
                super.onBeforeRender();
            }

            @Override
            protected void onModelChanging()
            {
                System.out.println("nestedSaveButton - onModelChanging.");
                super.onModelChanging();
            }

            @Override
            protected void onModelChanged()
            {
                System.out.println("nestedSaveButton - onModelChanged.");
                super.onModelChanged();
            }
        };
    }

    private AjaxLink<Void> buildNestedSaveButtonAjaxLink()
    {
        return new AjaxLink<Void>("nestedSaveButton")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                String msg = String.format("parentForm - onSubmit. parentTextField model object: %s | convertedInput: %s", nestedTextField.getModelObject(), nestedTextField.getConvertedInput());
                System.out.println(msg);
            }

            @Override
            protected void onBeforeRender()
            {
                System.out.println("nestedSaveButton - onBeforeRender.");
                super.onBeforeRender();
            }

            @Override
            protected void onModelChanging()
            {
                System.out.println("nestedSaveButton - onModelChanging.");
                super.onModelChanging();
            }

            @Override
            protected void onModelChanged()
            {
                System.out.println("nestedSaveButton - onModelChanged.");
                super.onModelChanged();
            }
        };
    }

    private TextField<String> buildNestedTextField()
    {
        return new TextField<String>("nestedTextField", Model.of("nested text field value"))
        {
            @Override
            protected void onBeforeRender()
            {
                System.out.println("nestedTextField - onBeforeRender.");
                super.onBeforeRender();
            }

            @Override
            protected void onModelChanging()
            {
                System.out.println("nestedTextField - onModelChanging.");
                super.onModelChanging();
            }

            @Override
            protected void onModelChanged()
            {
                System.out.println("nestedTextField - onModelChanged.");
                super.onModelChanged();
            }
        };
    }

    private Form<?> buildForm()
    {
        return new Form<Void>("nestedForm")
        {
            @Override
            protected void onSubmit()
            {
                System.out.println("nestedForm - onSubmit.");
                super.onSubmit();
            }
        };
    }
}
