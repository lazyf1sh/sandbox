package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.refreshingview;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Inspect resulting markup to understand how the refreshing view works
 */
public class RefreshingViewExamplePage extends WebPage
{

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        final List<IModel<String>> strings = new ArrayList<>();
        strings.add(Model.of("123"));
        strings.add(Model.of("456"));

        RefreshingView<String> refreshingView = new RefreshingView<String>("myRefreshingView", Model.of(strings))
        {
            @Override
            protected Iterator<IModel<String>> getItemModels()
            {
                return ((ArrayList)getDefaultModelObject()).iterator();
            }

            @Override
            protected void populateItem(final Item<String> item)
            {
                String value = item.getModelObject();
                Label label = new Label("myText", value);
                item.add(label);
            }
        };
        add(refreshingView);
    }
}
