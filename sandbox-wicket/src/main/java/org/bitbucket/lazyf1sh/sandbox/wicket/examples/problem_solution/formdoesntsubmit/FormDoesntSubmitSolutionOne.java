package org.bitbucket.lazyf1sh.sandbox.wicket.examples.problem_solution.formdoesntsubmit;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

/**
 * Problem: form submit doesnt trigge?
 * Why AjaxLink cannot be used to submit?
 *
 *
 * How much buttons can be added to submit form?
 */
public class FormDoesntSubmitSolutionOne extends WebPage
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

        AjaxSubmitLink link = new AjaxSubmitLink("myButton", form)
        {
            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form)
            {
                super.onSubmit(target, form);
                System.out.println("triggered");
            }
        };

        form.add(link);
        add(form);
    }
}
