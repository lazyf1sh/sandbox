package com.github.lazyf1sh.sandbox.wicket.examples.behaviors.ajax2;

import com.github.lazyf1sh.sandbox.wicket.util.RandomUuidModel;
import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.util.time.Duration;

/**
 * @author Ivan Kopylov
 */
public class AbstractAjaxTimerBehaviorExample extends WebPage
{
    private static final long serialVersionUID = 1090726579020985087L;

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Label label = new Label("label", new RandomUuidModel());
        label.setOutputMarkupId(true);
        add(label);

        add(new AbstractAjaxTimerBehavior(Duration.seconds(1))
        {
            private static final long serialVersionUID = 4953810211188590750L;

            @Override
            protected void onTimer(final AjaxRequestTarget target)
            {
                System.out.println("AbstractAjaxTimerBehavior - onTimer");
                target.add(label);
            }
        });
    }
}
