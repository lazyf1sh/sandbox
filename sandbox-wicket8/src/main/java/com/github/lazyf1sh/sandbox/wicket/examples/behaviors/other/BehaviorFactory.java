package com.github.lazyf1sh.sandbox.wicket.examples.behaviors.other;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.IAjaxCallListener;

public class BehaviorFactory
{
    public static AjaxEventBehavior get()
    {
        AjaxEventBehavior ajaxEventBehavior = new AjaxEventBehavior("keydown")
        {

            @Override
            protected void onEvent(final AjaxRequestTarget target)
            {
                System.out.println("123");
            }

            private static final long serialVersionUID = -7734303667397500L;

            @Override
            protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
            {
                super.updateAjaxAttributes(attributes);

                IAjaxCallListener listener = new AjaxCallListener()
                {
                    private static final long serialVersionUID = 1551746319850678324L;

                    @Override
                    public CharSequence getPrecondition(Component component)
                    {
                        return "var keycode = Wicket.Event.keyCode(attrs.event);"
                                + "if (keycode == 13) return true;"
                                + "else return false;";
                    }
                };
                attributes.getAjaxCallListeners().add(listener);
                attributes.getDynamicExtraParameters().add("var eventKeycode = Wicket.Event.keyCode(attrs.event);" + "return {keycode: eventKeycode};");
//                attributes.setAllowDefault(true);
            }
        };
        return ajaxEventBehavior;
    }
}
