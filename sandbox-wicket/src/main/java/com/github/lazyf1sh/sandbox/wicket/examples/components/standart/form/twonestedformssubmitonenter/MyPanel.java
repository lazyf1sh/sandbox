package com.github.lazyf1sh.sandbox.wicket.examples.components.standart.form.twonestedformssubmitonenter;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import com.github.lazyf1sh.sandbox.wicket.examples.components.standart.textfield.MyModelObject;

public class MyPanel extends Panel
{
    private MyModelObject myModelObject = new MyModelObject();

    public MyPanel(final String id)
    {
        super(id);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Form<?> form = new Form("nestedForm")
        {
            @Override
            protected void onSubmit()
            {
                super.onSubmit();
            }
        };

        form.setOutputMarkupId(true);
        add(form);

        final TextField textField = new TextField<>("textField", new PropertyModel<>(myModelObject, "prop"));
        textField.setOutputMarkupId(true);
        form.add(textField);

        AjaxSubmitLink searchButton2 = new AjaxSubmitLink("searchButton", form)
        {
            private static final long serialVersionUID = 8779923761589435319L;

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {
                System.out.println("123");
            }
        };
        form.add(searchButton2);
        form.setDefaultButton(searchButton2);
    }
}
