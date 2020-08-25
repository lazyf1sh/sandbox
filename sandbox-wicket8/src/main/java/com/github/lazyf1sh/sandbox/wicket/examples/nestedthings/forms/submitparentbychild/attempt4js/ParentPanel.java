package com.github.lazyf1sh.sandbox.wicket.examples.nestedthings.forms.submitparentbychild.attempt4js;

import com.github.lazyf1sh.sandbox.wicket.util.Util;
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

    private Form<?> parentForm;

    public ParentPanel(String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        parentForm = buildForm();
        parentForm.setOutputMarkupId(true);
        parentForm.setOutputMarkupPlaceholderTag(true);
        add(parentForm);

        parentTextField = buildTextField();
        parentForm.add(parentTextField);

        ModalWindow nestedWindow = new ModalWindow("nestedWindow");

        parentForm.add(nestedWindow);

        AjaxLink<Void> showNestedWindowButton = buildShowNestedWindowButton(nestedWindow);
        parentForm.add(showNestedWindowButton);

        AjaxButton parentSaveButton = buildParentSaveButton(parentForm);
        parentForm.add(parentSaveButton);
    }

    private AjaxButton buildParentSaveButton(Form<?> parentForm)
    {
        return new AjaxButton("parentSaveButton", parentForm)
        {
            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
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

    private AjaxLink<Void> buildShowNestedWindowButton(ModalWindow nestedWindow)
    {
        return new AjaxLink<Void>("showNestedWindow")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                Util.showComponentMessage(this);
                nestedWindow.setContent(new NestedPanel(nestedWindow.getContentId(), parentForm));
                nestedWindow.setTitle("Nested window");
                nestedWindow.show(target);
            }
        };
    }

    private TextField<String> buildTextField()
    {
        return new TextField<String>("parentTextField", Model.of("parent value"))
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
        return new Form<Void>("parentForm")
        {
            @Override
            protected void onSubmit()
            {
                String msg = String.format("parentTextField model object: %s, convertedInput: %s", parentTextField.getModelObject(), parentTextField.getConvertedInput());
                Util.showComponentMessage(this, msg);
                super.onSubmit();
            }
        };
    }
}
