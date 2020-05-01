package com.github.lazyf1sh.sandbox.wicket.examples.components.standart.defaultnestedtree.folderchecked;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.markup.html.repeater.tree.DefaultNestedTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.content.CheckedFolder;
import org.apache.wicket.extensions.markup.html.repeater.util.ProviderSubset;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class CheckedFolderTreePage extends WebPage
{
    private DefaultNestedTree<CheckedFolderNode> defaultNestedTree;
    private SomeTreeNodeProvider                 nodeProvider = new SomeTreeNodeProvider();
    private ProviderSubset<CheckedFolderNode>    checked;

    protected boolean isChecked(CheckedFolderNode CheckedFolderNode)
    {
        return checked.contains(CheckedFolderNode);
    }

    protected void check(CheckedFolderNode CheckedFolderNode, boolean check)
    {
        if (check)
        {
            checked.add(CheckedFolderNode);
        }
        else
        {
            checked.remove(CheckedFolderNode);
        }
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        nodeProvider.reload();
        checked = new ProviderSubset<>(nodeProvider, false);

        defaultNestedTree = new DefaultNestedTree<CheckedFolderNode>("tree", nodeProvider)
        {
            private static final long serialVersionUID = 8576320104417070206L;

            @Override
            protected Component newContentComponent(final String id, final IModel<CheckedFolderNode> model)
            {
                return new CheckedFolder<CheckedFolderNode>(id, this, model)
                {
                    private static final long serialVersionUID = -5758392313825309170L;

                    @Override
                    protected void onUpdate(final AjaxRequestTarget target)
                    {
                        super.onUpdate(target);
                    }

                    @Override
                    protected IModel<Boolean> newCheckBoxModel(final IModel<CheckedFolderNode> model)
                    {
                        return new IModel<Boolean>()
                        {
                            @Override
                            public void detach()
                            {

                            }

                            private static final long serialVersionUID = 1L;

                            @Override
                            public Boolean getObject()
                            {
                                return isChecked(model.getObject());
                            }

                            @Override
                            public void setObject(Boolean object)
                            {
                                check(model.getObject(), object);
                            }
                        };
                    }
                };
            }
        };

        AjaxLink link = new AjaxLink("trigger", Model.of("link text"))
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                System.out.println("on click");
                for (CheckedFolderNode node : checked)
                {
                    System.out.println(node);
                }
            }
        };

        add(link, defaultNestedTree);

    }
}
