package com.github.lazyf1sh.sandbox.wicket.examples.behaviors.ajax;

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.time.Duration;

/**
 * @author Ivan Kopylov
 */
public class AjaxSelfUpdatingTimerBehaviorExample extends WebPage
{
    private static final long serialVersionUID = 1090726579020985087L;

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        final TextField<String> myTextField = new TextField<String>("myTextField", Model.of("1"));
        myTextField.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(2)));
        myTextField.setOutputMarkupId(true);

        add(myTextField);
    }

}
