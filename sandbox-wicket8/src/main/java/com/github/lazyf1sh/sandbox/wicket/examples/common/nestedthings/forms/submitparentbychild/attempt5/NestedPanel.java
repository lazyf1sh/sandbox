package com.github.lazyf1sh.sandbox.wicket.examples.common.nestedthings.forms.submitparentbychild.attempt5;

import com.github.lazyf1sh.sandbox.wicket.util.Util;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 * @author Ivan Kopylov
 */
public class NestedPanel extends Panel
{
    private AjaxButton nestedSaveButton;
    public NestedPanel(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Form<?> nestedForm = buildNestedForm();

        TextField<String> textFieldNested = buildTextFieldNested();
        nestedForm.add(textFieldNested);

        nestedSaveButton = buildNestedSaveButton(nestedForm);
        nestedForm.add(nestedSaveButton);
    }

    private AjaxButton buildNestedSaveButton(Form<?> nestedForm)
    {
        return new AjaxButton("nestedSaveButton", nestedForm)
            {
                @Override
                protected void onSubmit(AjaxRequestTarget target)
                {
                    String msg = String.format("nestedSaveButton model object: %s, convertedInput: %s", nestedSaveButton.getModelObject(), nestedSaveButton.getConvertedInput());
                    Util.showComponentMessage(this, msg);
                    Util.showComponentMessage(this);
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

    private TextField<String> buildTextFieldNested()
    {
        return new TextField<String>("nestedTextField", Model.of("nested text field value"))
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

    private Form<?> buildNestedForm()
    {
        Form<?> nestedForm = new Form<Void>("nestedForm")
        {
            @Override
            protected void onSubmit()
            {
                Util.showComponentMessage(this);
                super.onSubmit();
            }
        };
        add(nestedForm);
        return nestedForm;
    }
}
