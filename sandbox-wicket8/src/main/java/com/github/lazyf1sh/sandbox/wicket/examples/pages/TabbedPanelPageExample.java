package com.github.lazyf1sh.sandbox.wicket.examples.pages;

import java.util.ArrayList;
import java.util.List;

import com.github.lazyf1sh.sandbox.wicket.examples.components.tab.MyTabOne;
import com.github.lazyf1sh.sandbox.wicket.examples.components.tab.MyTabTwo;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class TabbedPanelPageExample extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        List<ITab> tabs = new ArrayList<>();
        tabs.add(new AbstractTab(new Model<>("first tab"))
        {
            @Override
            public Panel getPanel(String panelId)
            {
                return new MyTabOne(panelId);
            }
        });

        tabs.add(new AbstractTab(new Model<>("second tab"))
        {
            @Override
            public Panel getPanel(String panelId)
            {
                return new MyTabTwo(panelId);
            }
        });

        add(new AjaxTabbedPanel<>("tabs", tabs));
    }
}
