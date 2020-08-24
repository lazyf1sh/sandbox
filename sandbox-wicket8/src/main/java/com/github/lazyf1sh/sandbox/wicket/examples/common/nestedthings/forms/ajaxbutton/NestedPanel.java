package com.github.lazyf1sh.sandbox.wicket.examples.common.nestedthings.forms.ajaxbutton;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
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
    public NestedPanel(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Form<?> nestedForm = new Form<Void>("nestedForm")
        {
            @Override
            protected void onSubmit()
            {
                System.out.println("nestedForm - onSubmit.");
                super.onSubmit();
            }
        };
        add(nestedForm);

        TextField<String> textFieldNested = new TextField<String>("nestedTextField", Model.of("nested text field value"))
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
        nestedForm.add(textFieldNested);


        nestedForm.add(new AjaxButton("nestedSaveButton", nestedForm)
        {
            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                System.out.println("nestedSaveButton - onSubmit.");
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
        });
    }
}
