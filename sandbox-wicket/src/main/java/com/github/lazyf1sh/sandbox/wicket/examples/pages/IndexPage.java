package com.github.lazyf1sh.sandbox.wicket.examples.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;

import com.github.lazyf1sh.sandbox.wicket.examples.behaviors.ajax.AjaxSelfUpdatingTimerBehaviorExample;
import com.github.lazyf1sh.sandbox.wicket.examples.behaviors.ajax2.AbstractAjaxTimerBehaviorExample;
import com.github.lazyf1sh.sandbox.wicket.examples.behaviors.other.AbstractDefaultAjaxBehaviorExample;
import com.github.lazyf1sh.sandbox.wicket.examples.behaviors.other.AbstractDefaultAjaxBehaviorExample2;
import com.github.lazyf1sh.sandbox.wicket.examples.behaviors.other.AbstractDefaultAjaxBehaviorExample4;
import com.github.lazyf1sh.sandbox.wicket.examples.converter.BigDecimalConverterExample;
import com.github.lazyf1sh.sandbox.wicket.examples.models.dynamicmodel.DynamicModelExample;
import com.github.lazyf1sh.sandbox.wicket.examples.models.loadabledetachable.LoadableDetachableModelExample;
import com.github.lazyf1sh.sandbox.wicket.examples.models.staticmodel.StaticModelExample;
import com.github.lazyf1sh.sandbox.wicket.examples.prototypes.documentdialog.MyPageWithModalWindow;

/**
 * @author Ivan Kopylov
 */
public class IndexPage extends WebPage
{
    private static final long serialVersionUID = 1388829190396256439L;

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

        AjaxLink<Void> pageWithModalWindow = new AjaxLink<Void>("pageWithModalWindow")
        {
            private static final long serialVersionUID = -3445086817091447502L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                setResponsePage(PageWithModalWindow.class);
            }
        };
        add(pageWithModalWindow);

        AjaxLink<Void> myPageWithModalWindow = new AjaxLink<Void>("myPageWithModalWindow")
        {
            private static final long serialVersionUID = -3445086817091447502L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                setResponsePage(MyPageWithModalWindow.class);
            }
        };
        add(myPageWithModalWindow);

        AjaxLink<Void> abstractDefaultAjaxBehaviorExample = new AjaxLink<Void>("abstractDefaultAjaxBehaviorExample")
        {
            private static final long serialVersionUID = -3445086817091447502L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                setResponsePage(AbstractDefaultAjaxBehaviorExample.class);
            }
        };
        add(abstractDefaultAjaxBehaviorExample);

        AjaxLink<Void> abstractDefaultAjaxBehaviorExample2 = new AjaxLink<Void>("abstractDefaultAjaxBehaviorExample2")
        {
            private static final long serialVersionUID = -3445086817091447502L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                setResponsePage(AbstractDefaultAjaxBehaviorExample2.class);
            }
        };
        add(abstractDefaultAjaxBehaviorExample2);

        AjaxLink<Void> abstractDefaultAjaxBehaviorExample3 = new AjaxLink<Void>("abstractDefaultAjaxBehaviorExample3")
        {
            private static final long serialVersionUID = -3445086817091447502L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                setResponsePage(AbstractDefaultAjaxBehaviorExample4.class);
            }
        };
        add(abstractDefaultAjaxBehaviorExample3);

        AjaxLink<Void> ajaxSelfUpdatingTimerBehaviorExample = new AjaxLink<Void>("ajaxSelfUpdatingTimerBehaviorExample")
        {
            private static final long serialVersionUID = -3445086817091447502L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                setResponsePage(AjaxSelfUpdatingTimerBehaviorExample.class);
            }
        };
        add(ajaxSelfUpdatingTimerBehaviorExample);

        AjaxLink<Void> abstractAjaxTimerBehaviorExample = new AjaxLink<Void>("abstractAjaxTimerBehaviorExample")
        {
            private static final long serialVersionUID = -3445086817091447502L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                setResponsePage(AbstractAjaxTimerBehaviorExample.class);
            }
        };
        add(abstractAjaxTimerBehaviorExample);

        AjaxLink<Void> bigDecimalConverterExample = new AjaxLink<Void>("bigDecimalConverterExample")
        {
            private static final long serialVersionUID = -3445086817091447502L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                setResponsePage(BigDecimalConverterExample.class);
            }
        };
        add(bigDecimalConverterExample);

    }
}
