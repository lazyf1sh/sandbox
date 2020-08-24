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
    private final Form<?>     formToSubmit;
    private TextField<String> nestedTextField;
    public NestedPanel(String id, Form<?> form)
    {
        super(id);
        this.formToSubmit = form;
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        nestedTextField = buildNestedTextField();
        add(nestedTextField);
        if (formToSubmit != null)
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
        return new AjaxSubmitLink("nestedSaveButton", formToSubmit)
        {
            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {

                System.out.println("[AjaxSubmitLink] nestedSaveButton - onSubmit. Text field model object: " + nestedTextField.getModelObject());
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
                System.out.println("[AjaxLink] nestedSaveButton - onClick. Text field model object:" + nestedTextField.getModelObject());
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
