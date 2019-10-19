package org.bitbucket.lazyf1sh.sandbox.wicket.examples.components.standart.form.twonestedformssubmitonenter2;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.bitbucket.lazyf1sh.sandbox.wicket.examples.behaviors.other2.AjaxPreventSubmitBehavior;
import org.bitbucket.lazyf1sh.sandbox.wicket.examples.components.standart.textfield.MyModelObject;

public class MyPanel extends Panel
{
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

        final Form<?> form = new Form("nestedForm")
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


        AjaxSubmitLink searchButton2 = new AjaxSubmitLink("searchButton2", form)
        {
            private static final long serialVersionUID = 8779923761589435319L;

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {
                System.out.println("searchButton2 - onSubmit");
            }
        };
        form.setDefaultButton(searchButton);
        form.add(searchButton2);
    }
}
