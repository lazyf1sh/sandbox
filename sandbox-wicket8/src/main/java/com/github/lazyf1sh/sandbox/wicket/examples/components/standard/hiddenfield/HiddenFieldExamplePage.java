package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.hiddenfield;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.HiddenField;

/**
 * @author Ivan Kopylov
 */
public class HiddenFieldExamplePage extends WebPage
{

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        HiddenField<String> hiddenField = new HiddenField<>("myHiddenField");
        hiddenField.setOutputMarkupId(true);
        hiddenField.add(new AjaxEventBehavior("change")
        {
            @Override
            protected void onEvent(AjaxRequestTarget target)
            {
                System.out.println("AjaxEventBehavior - onEvent");
            }
        });
        add(hiddenField);

        AjaxLink<?> linkButton = new AjaxLink<Void>("changeHiddenField")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                target.appendJavaScript(String.format("$('#%s').change()", hiddenField.getMarkupId()));
            }
        };

        add(linkButton);
    }
}
