package com.github.lazyf1sh.sandbox.wicket.examples.components.standart.form.nestedforms.basic;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

public class NestedFormsExample extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        NestedPanelWithForm panel = new NestedPanelWithForm("myPanel");

        Form<?> form = new Form<Void>("form")
        {
            private static final long serialVersionUID = -1095582817776277394L;

            @Override
            protected void onSubmit()
            {
                super.onSubmit();
                //parent form will be triggered
            }
        };
        form.add(panel);
        add(form);
    }
}
