package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.radiochoice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormChoiceComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

/**
 * http://examples7x.wicket.apache.org/compref/wicket/bookmarkable/org.apache.wicket.examples.compref.RadioChoicePage?0
 *
 * @author Ivan Kopylov
 */
public class RadioChoiceOnUpdate extends WebPage
{
    private static final List<String> TYPES = Arrays.asList("Shared Host", "VPS", "Dedicated Server");

    private static final long serialVersionUID = -1923626121356192574L;

    private String selected = null;

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        FeedbackPanel feedback = new FeedbackPanel("feedback");
        add(feedback);

        RadioChoice<String> radioGroup = new RadioChoice<String>("radioGroup", new PropertyModel<String>(this, "selected"), TYPES);
        radioGroup.setOutputMarkupId(true);
        add(radioGroup);

        final AtomicInteger i = new AtomicInteger();
        i.set(0);

        radioGroup.add(new AjaxFormChoiceComponentUpdatingBehavior()
        {
            private static final long serialVersionUID = 1650327455031546028L;

            @Override
            protected void onUpdate(AjaxRequestTarget target)
            {
                if (i.incrementAndGet() % 2 == 0)
                {
                    getComponent().getDefaultModel().setObject(null);
                }

                System.out.println("RadioChoiceOnUpdate");
                info("RadioChoiceOnUpdate");
                target.add(radioGroup, feedback);
            }
        });
    }
}
