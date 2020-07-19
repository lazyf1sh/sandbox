package com.github.lazyf1sh.sandbox.wicket.examples.pages;

import com.github.lazyf1sh.sandbox.wicket.examples.modaldialog.ModalWindowExamplePage;
import com.github.lazyf1sh.sandbox.wicket.examples.nesteddialogs.NestedModalWindowExamplePage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.markup.repeater.util.ModelIteratorAdapter;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Ivan Kopylov
 */
public class IndexPage extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        RefreshingView<Class<?>> refreshingView = new RefreshingView<Class<?>>("listPages")
        {
            @Override
            protected Iterator<IModel<Class<?>>> getItemModels()
            {
                Class<?>[] pages = {ModalWindowExamplePage.class, NestedModalWindowExamplePage.class};

                return new ModelIteratorAdapter<Class<?>>(Arrays.stream(pages).iterator())
                {
                    @Override
                    protected IModel<Class<?>> model(Class<?> object)
                    {
                        return Model.of(object);
                    }
                };
            }

            @Override
            protected void populateItem(Item item)
            {
                Class clazz = (Class) item.getModelObject();

                AjaxLink<String> myModalWindowPage = new AjaxLink<String>("pageLink", Model.of(clazz.getName()))
                {
                    @Override
                    public void onClick(AjaxRequestTarget target)
                    {
                        setResponsePage(clazz);
                    }
                };
                item.add(myModalWindowPage);
            }
        };
        add(refreshingView);


    }
}
