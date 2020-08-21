package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.dropdownchoice;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Arrays;
import java.util.List;

/**
 * Dropdown choice submits on form submit, not only selecting dropdown element
 */
public class DropDownChoiceExample extends WebPage
{
    private static final List<String> SEARCH_ENGINES = Arrays.asList(new String[] { "1", "2", "3" });

    public DropDownChoiceExample(final PageParameters parameters)
    {
        add(new FeedbackPanel("feedback"));

        setDefaultModel(Model.of("4"));

        DropDownChoice<String> listSites = new DropDownChoice<String>("sites", (IModel<String>)getDefaultModel(), SEARCH_ENGINES);

        Form<?> form = new Form<Void>("form")
        {
            @Override
            protected void onSubmit()
            {
                info("Selected search engine : " + DropDownChoiceExample.this.getDefaultModelObject());
            }
        };

        add(form);
        form.add(listSites);
    }
}