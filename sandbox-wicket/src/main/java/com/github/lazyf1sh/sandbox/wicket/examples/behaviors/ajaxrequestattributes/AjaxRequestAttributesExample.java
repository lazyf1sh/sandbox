package com.github.lazyf1sh.sandbox.wicket.examples.behaviors.ajaxrequestattributes;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import com.github.lazyf1sh.sandbox.wicket.examples.behaviors.other2.BehaviorFactory;

public class AjaxRequestAttributesExample extends WebPage
{
    private static final long serialVersionUID = 7352203927463159738L;

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        final TextField<String> myTextField = new TextField<String>("myTextField", Model.of("1"));
        myTextField.setOutputMarkupId(true);
        myTextField.add(BehaviorFactory.get());
        add(myTextField);

    }
}
