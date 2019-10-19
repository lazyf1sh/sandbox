package org.bitbucket.lazyf1sh.sandbox.wicket.examples.components.standart.form.twonestedformssubmitonenter;

import java.util.Optional;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class ParentChildFromSubmitBugCandidate extends WebPage
{

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        final Form<?> form = new Form("form")
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
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {
                System.out.println("123");
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
