package org.bitbucket.lazyf1sh.sandbox.wicket.examples.components.standart.buttonslinks.ajaxlink;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

/**
 * Purpose of this example: this is one of examples in a set of demonstrating wicket ways to call backend with various types of triggers
 */
public class AjaxSubmitLinkExample extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Form<?> form = new Form("myForm")
        {
            @Override
            protected void onSubmit()
            {
                super.onSubmit();
                System.out.println("Form onSubmit have been triggered");
            }

            @Override
            protected void onError()
            {
                super.onError();
                System.out.println("Form onError have been triggered");
            }
        };

        AjaxSubmitLink link = new AjaxSubmitLink("myButton", form)
        {
            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form)
            {
                super.onSubmit(target, form);
            }
        };
        form.add(link);
        add(form);
    }
}
