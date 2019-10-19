package org.bitbucket.lazyf1sh.sandbox.wicket.examples.problem_solution.formdoesntsubmit;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

/**
 * Demonstrates solution (see package for the problem)
 */
public class FormDoesntSubmitSolutionTwo extends WebPage
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
                System.out.println("Form onsubmit triggered");
            }

            @Override
            protected void onError()
            {
                super.onError();
            }
        };

        AjaxButton link = new AjaxButton("myButton", form)
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
