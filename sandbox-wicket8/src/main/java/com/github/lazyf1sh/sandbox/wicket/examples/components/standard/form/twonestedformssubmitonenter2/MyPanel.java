package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.form.twonestedformssubmitonenter2;

import com.github.lazyf1sh.sandbox.wicket.examples.components.standard.textfield.MyModelObject;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;


import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

public class MyPanel extends Panel
{
    private static final long serialVersionUID = -5825190184127240781L;

    private MyModelObject  myModelObject = new MyModelObject();
    private AjaxSubmitLink searchButton;

    public MyPanel(final String id, AjaxSubmitLink searchButton)
    {
        super(id);
        this.searchButton = searchButton;
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        final Form<?> form = new Form<Void>("nestedForm")
        {
            private static final long serialVersionUID = -2665226028753832979L;

            @Override
            protected void onSubmit()
            {
                super.onSubmit();
            }
        };
        form.setOutputMarkupId(true);
        add(form);

        final TextField<Void> textField = new TextField<>("textField", new PropertyModel<>(myModelObject, "prop"));
        textField.setOutputMarkupId(true);
        form.add(textField);


        AjaxSubmitLink searchButton2 = new AjaxSubmitLink("searchButton2", form)
        {
            private static final long serialVersionUID = 8779923761589435319L;


            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                super.onSubmit(target);
                System.out.println("searchButton2 - onSubmit");
            }
        };
        form.setDefaultButton(searchButton);
        form.add(searchButton2);
    }
}
