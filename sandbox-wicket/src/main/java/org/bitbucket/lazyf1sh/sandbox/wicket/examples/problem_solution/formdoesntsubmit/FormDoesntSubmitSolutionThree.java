package org.bitbucket.lazyf1sh.sandbox.wicket.examples.problem_solution.formdoesntsubmit;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

/**
 * Demonstrates that ajaxsubmit link not in the hierarchy
 */
public class FormDoesntSubmitSolutionThree extends WebPage
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

        AjaxSubmitLink link = new AjaxSubmitLink("myButton", form)
        {
            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form)
            {
                super.onSubmit(target, form);
            }
        };

        //from javadoc:
        //A link that submits a form via ajax. Since this link takes the form as a constructor argument it does not need to be inside form's component hierarchy.r
        add(link);
        add(form);
    }
}
