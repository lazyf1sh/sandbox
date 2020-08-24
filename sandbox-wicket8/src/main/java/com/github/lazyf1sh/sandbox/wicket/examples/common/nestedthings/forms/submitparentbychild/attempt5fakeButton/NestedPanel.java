package com.github.lazyf1sh.sandbox.wicket.examples.common.nestedthings.forms.submitparentbychild.attempt5fakeButton;

import com.github.lazyf1sh.sandbox.wicket.util.Util;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.visit.IVisitor;

/**
 * @author Ivan Kopylov
 */
public class NestedPanel extends Panel
{

    private TextField<String> textFieldNested;


    public NestedPanel(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Form<?> nestedForm = buildForm();
        add(nestedForm);

        textFieldNested = buildTextField();
        nestedForm.add(textFieldNested);

        AjaxButton nestedSaveButton = buildNestedSaveButton(nestedForm);
        nestedForm.add(nestedSaveButton);
    }

    private AjaxButton buildNestedSaveButton(Form<?> nestedForm)
    {
        return new AjaxButton("nestedSaveButton", nestedForm)
        {
            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                String msg = String.format("parentTextField model object: %s, convertedInput: %s", textFieldNested.getModelObject(), textFieldNested.getConvertedInput());
                Util.showComponentMessage(this, msg);

                NestedPanel.this.getPage().visitChildren((IVisitor<Component, Void>) (object, visit) -> {
                    if (object.getId().equals("parentSaveButton"))
                    {
                        NestedPanel.this.send(object, Broadcast.EXACT, "qwe");
                    }
                });

                super.onSubmit(target);
            }

            @Override
            protected void onBeforeRender()
            {
                Util.showComponentMessage(this);
                super.onBeforeRender();
            }

            @Override
            protected void onModelChanging()
            {
                Util.showComponentMessage(this);
                super.onModelChanging();
            }

            @Override
            protected void onModelChanged()
            {
                Util.showComponentMessage(this);
                super.onModelChanged();
            }
        };
    }

    private TextField<String> buildTextField()
    {
        return new TextField<String>("nestedTextField", Model.of("nested value"))
        {
            @Override
            protected void onBeforeRender()
            {
                Util.showComponentMessage(this);
                super.onBeforeRender();
            }

            @Override
            protected void onModelChanging()
            {
                Util.showComponentMessage(this);
                super.onModelChanging();
            }

            @Override
            protected void onModelChanged()
            {
                Util.showComponentMessage(this);
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
                Util.showComponentMessage(this);
                super.onSubmit();
            }
        };
    }
}
