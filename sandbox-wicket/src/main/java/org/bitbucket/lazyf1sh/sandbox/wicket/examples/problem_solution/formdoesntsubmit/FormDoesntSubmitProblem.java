package org.bitbucket.lazyf1sh.sandbox.wicket.examples.problem_solution.formdoesntsubmit;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

/**
 * Problem: form submit doesnt trigge?
 * Why AjaxLink cannot be used to submit?
 *
 *
 * How much buttons can be added to submit form?
 */
public class FormDoesntSubmitProblem extends WebPage
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
            }

            @Override
            protected void onError()
            {
                super.onError();
            }
        };

        AjaxLink link = new AjaxLink("myButton")
        {
            @Override
            public void onClick(final AjaxRequestTarget target)
            {
                System.out.println("triggered");
            }
        };

        form.add(link);
        add(form);
    }
}
