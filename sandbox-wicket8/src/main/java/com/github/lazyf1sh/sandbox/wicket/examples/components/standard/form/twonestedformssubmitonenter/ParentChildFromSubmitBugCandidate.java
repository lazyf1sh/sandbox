package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.form.twonestedformssubmitonenter;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

public class ParentChildFromSubmitBugCandidate extends WebPage
{

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        final Form<?> form = new Form<Void>("form")
        {
            @Override
            protected void onSubmit()
            {
                super.onSubmit();
            }
        };

        form.setOutputMarkupId(true);
        add(form);

        AjaxSubmitLink searchButton = new AjaxSubmitLink("searchButton", form)
        {
            private static final long serialVersionUID = 8779923761589435319L;


            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                super.onSubmit(target);
            }
        };
        form.add(searchButton);
        form.setDefaultButton(searchButton);

        MyPanel panel1 = new MyPanel("myPanel1");
        form.add(panel1);

        MyPanel panel2 = new MyPanel("myPanel2");
        form.add(panel2);
    }
}
