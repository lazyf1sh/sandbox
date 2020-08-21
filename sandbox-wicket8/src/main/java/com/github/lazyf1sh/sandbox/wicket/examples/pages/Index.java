package com.github.lazyf1sh.sandbox.wicket.examples.pages;

import com.github.lazyf1sh.sandbox.wicket.util.Util;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.markup.repeater.util.ModelIteratorAdapter;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ivan Kopylov
 */
public class Index extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        List<Class<?>> classes = getPagesClasses();

        RefreshingView<Class<?>> refreshingView = new RefreshingView<Class<?>>("listPages")
        {
            @Override
            protected Iterator<IModel<Class<?>>> getItemModels()
            {
                return new ModelIteratorAdapter<Class<?>>(classes.iterator())
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

                AjaxLink<String> myModalWindowPage = new AjaxLink<String>("pageLink")
                {
                    @Override
                    public void onClick(AjaxRequestTarget target)
                    {
                        setResponsePage(clazz);
                    }
                };
                item.add(myModalWindowPage);

                myModalWindowPage.add(new Label("pageLinkLabel", Model.of(clazz.getName())));
            }
        };
        add(refreshingView);


    }

    private List<Class<?>> getPagesClasses()
    {
        String searchFrom = "com.github.lazyf1sh";
        List<Class<?>> result = new ArrayList<>();
        URL root = Thread.currentThread().getContextClassLoader().getResource("");
        if (root != null)
        {
            String file1 = root.getFile();

            List<File> listf = Util.listf(file1, new ArrayList<>());
            List<File> files = listf.stream().filter(file -> file.getName().endsWith(".class")).collect(Collectors.toList());

            for (File file : files)
            {
                try
                {

                    String dottedPath = file.getAbsolutePath().replaceAll("\\\\", ".");
                    int index = dottedPath.indexOf(searchFrom);
                    String fqClassName = dottedPath
                            .substring(index)
                            .replace(".class", "");

                    Class<?> cls = Class.forName(fqClassName);
                    if (WebPage.class.isAssignableFrom(cls))
                    {
                        result.add(cls);
                    }
                }
                catch (ClassNotFoundException e)
                {
                    e.printStackTrace();
                    throw new RuntimeException("");
                }
            }
        }
        else
        {
            throw new RuntimeException("");
        }

        return result;
    }
}
