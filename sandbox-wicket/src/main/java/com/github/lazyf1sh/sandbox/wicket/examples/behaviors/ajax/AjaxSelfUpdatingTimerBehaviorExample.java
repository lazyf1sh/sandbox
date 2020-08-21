package com.github.lazyf1sh.sandbox.wicket.examples.behaviors.ajax;

import com.github.lazyf1sh.sandbox.wicket.util.RandomUuidModel;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.time.Duration;

import java.util.UUID;

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

        final TextField<String> myTextField = new TextField<>("myTextField", new RandomUuidModel());
        myTextField.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(2)));
        myTextField.setOutputMarkupId(true);

        add(myTextField);
    }
}
