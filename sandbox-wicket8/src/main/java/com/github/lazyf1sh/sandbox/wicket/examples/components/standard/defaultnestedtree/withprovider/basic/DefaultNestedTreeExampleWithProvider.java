package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.defaultnestedtree.withprovider.basic;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

public class DefaultNestedTreeExampleWithProvider extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        final MyStructProvider myStructProvider = new MyStructProvider();

        final DefaultNestedTree<MyStruct> defaultNestedTree = new DefaultNestedTree<MyStruct>("tree", myStructProvider)
        {

        };
        defaultNestedTree.setOutputMarkupId(true);
        add(defaultNestedTree);

        AjaxLink<String> ajaxLink = new AjaxLink<String>("updateTree", Model.of("button text"))
        {
            @Override
            public void onClick(final AjaxRequestTarget target)
            {
                myStructProvider.detach();
                myStructProvider.reload();
                target.add(defaultNestedTree);
            }
        };
        add(ajaxLink);
    }
}
