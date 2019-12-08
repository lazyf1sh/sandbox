package com.github.lazyf1sh.sandbox.wicket.examples.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;

import com.github.lazyf1sh.sandbox.wicket.examples.models.dynamicmodel.DynamicModelExample;
import com.github.lazyf1sh.sandbox.wicket.examples.models.loadabledetachable.LoadableDetachableModelExample;
import com.github.lazyf1sh.sandbox.wicket.examples.models.staticmodel.StaticModelExample;

/**
 * @author Ivan Kopylov
 */
public class IndexPage extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        AjaxLink<Void> dynamicModelExample = new AjaxLink<Void>("dynamicModelExample")
        {
            private static final long serialVersionUID = -3445086817091447502L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                setResponsePage(DynamicModelExample.class);
            }
        };
        add(dynamicModelExample);

        AjaxLink<Void> staticModelExample = new AjaxLink<Void>("staticModelExample")
        {
            private static final long serialVersionUID = -3445086817091447502L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                setResponsePage(StaticModelExample.class);
            }
        };
        add(staticModelExample);

        AjaxLink<Void> loadableDetachableModel = new AjaxLink<Void>("loadableDetachableModel")
        {
            private static final long serialVersionUID = -3445086817091447502L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                setResponsePage(LoadableDetachableModelExample.class);
            }
        };
        add(loadableDetachableModel);

        AjaxLink<Void> radioChoicePageExample = new AjaxLink<Void>("radioChoicePageExample")
        {
            private static final long serialVersionUID = -3445086817091447502L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                setResponsePage(RadioChoicePageExample.class);
            }
        };
        add(radioChoicePageExample);

        AjaxLink<Void> validatorExample = new AjaxLink<Void>("validatorExample")
        {
            private static final long serialVersionUID = -3445086817091447502L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                setResponsePage(ValidatorExamplePage.class);
            }
        };
        add(validatorExample);

    }
}
