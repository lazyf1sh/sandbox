package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.radiochoice;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.validator.EmailAddressValidator;

/**
 * @author Ivan Kopylov
 */
public class RadioChoicePageExample extends WebPage
{
    private static final List<String> TYPES = Arrays.asList("Shared Host", "VPS", "Dedicated Server");

    private static final long serialVersionUID = -1923626121356192574L;

    private String selected = null;

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        add(new FeedbackPanel("feedback"));

        RadioChoice<String> hostingType = new RadioChoice<String>("hosting", new PropertyModel<String>(this, "selected"), TYPES);

        Form<?> form = new Form<Void>("form")
        {
            private static final long serialVersionUID = -5672719273595835054L;

            @Override
            protected void onSubmit()
            {
                info("Selected Type : " + selected);
            }
        };

        add(form);
        form.add(hostingType);
    }
}
