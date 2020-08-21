package com.github.lazyf1sh.sandbox.wicket.examples.nested.forms;

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

        Form<?> parentForm = new Form<>("parentForm");
        add(parentForm);

        TextField<String> textField1 = new TextField<>("textField1", Model.of("textField1"));
        parentForm.add(textField1);

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

        parentForm.add(new AjaxButton("saveButton", parentForm)
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
