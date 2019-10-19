package org.bitbucket.lazyf1sh.sandbox.wicket.examples.pages;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.bitbucket.lazyf1sh.sandbox.wicket.examples.behaviors.other2.AjaxPreventSubmitBehavior;

/**
 *
 * Purpose of this example: to show
 * What reader should know:
 * Complexity:
 */
public class AjaxEventBehaviorPreconditionExample extends WebPage
{
    private AjaxEventBehaviorPreconditionModel model;

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        model = new AjaxEventBehaviorPreconditionModel();
        model.setTextField("213");
        TextField myTextField = new TextField("myTextField", new PropertyModel(model, "textField"));
        myTextField.setOutputMarkupId(true);
        myTextField.setOutputMarkupPlaceholderTag(true);
        myTextField.add(new AjaxFormComponentUpdatingBehavior("keydown")
        {
            @Override
            protected void updateAjaxAttributes(final AjaxRequestAttributes attributes)
            {
                super.updateAjaxAttributes(attributes);

                Component component = getComponent();
                if (component instanceof TextField<?> == false)
                {
                    attributes.setChildSelector("input");
                }

                AjaxCallListener listener = new AjaxCallListener();
                listener.onPrecondition("if (Wicket.Event.keyCode(attrs.event) !== 13) { console.log('anykey press has been prevented'); return false; } console.log('keycode 13 is passed precondition'); return true;");
                //        attributes.getDynamicExtraParameters().add("var eventKeycode = Wicket.Event.keyCode(attrs.event);" + "return {keycode: eventKeycode};");
                attributes.getAjaxCallListeners().add(listener);
                attributes.setAllowDefault(true);
            }



            @Override
            protected void onUpdate(final AjaxRequestTarget target)
            {
                System.out.println("");
            }
        });
        add(myTextField);
    }
}
