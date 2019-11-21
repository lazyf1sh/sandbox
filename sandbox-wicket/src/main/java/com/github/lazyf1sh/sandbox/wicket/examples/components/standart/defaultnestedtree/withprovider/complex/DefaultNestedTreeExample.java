package com.github.lazyf1sh.sandbox.wicket.examples.components.standart.defaultnestedtree.withprovider.complex;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

public class DefaultNestedTreeExample extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        final MyStructProvider myStructProvider = new MyStructProvider();

        final DefaultNestedTree<MyNode> defaultNestedTree = new DefaultNestedTree<MyNode>("tree", myStructProvider);
        defaultNestedTree.setOutputMarkupId(true);
        add(defaultNestedTree);

        AjaxLink ajaxLink = new AjaxLink("updateTree", Model.of("button text"))
        {
            @Override
            public void onClick(final AjaxRequestTarget target)
            {
                myStructProvider.reload();
                target.add(defaultNestedTree);
            }
        };
        add(ajaxLink);
    }
}
