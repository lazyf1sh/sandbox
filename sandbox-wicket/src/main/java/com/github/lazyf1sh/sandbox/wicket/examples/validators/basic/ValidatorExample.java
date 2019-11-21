package com.github.lazyf1sh.sandbox.wicket.examples.validators.basic;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.EmailAddressValidator;

/**
 * Check html output. On falied validation wicked adds "error" class thanks to {@link ErrorIndicatorBehavior}
 */
public class ValidatorExample extends WebPage
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

            @Override
            protected void onError()
            {
                super.onError();
            }
        };
        form.setOutputMarkupId(true);

        TextField<String> myTextField = new TextField<>("myTextField", Model.of("test"));
        myTextField.add(EmailAddressValidator.getInstance());
        myTextField.add(new ErrorIndicatorBehavior());
        myTextField.setOutputMarkupId(true);
        form.add(myTextField);
        add(form);
    }
}
