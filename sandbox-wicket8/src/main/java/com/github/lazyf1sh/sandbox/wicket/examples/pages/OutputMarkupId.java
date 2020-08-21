package com.github.lazyf1sh.sandbox.wicket.examples.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class OutputMarkupId extends WebPage
{
    private static final long serialVersionUID = 5628062157608422843L;

    public OutputMarkupId()
    {
        final TextField<String> username = new TextField<>("username", Model.of("1"));
        username.setOutputMarkupId(true);

        // when setOutputMarkupId is false:
        //<input wicket:id="username" type="text" size="20" value="1" name="username">

        // when setOutputMarkupId is true:
        //<input wicket:id="username" type="text" size="20" value="1" name="username" id="username6">

        add(username);

        //any added behaviour sets setOutputMarkupId = true (to be able to operate component), e.g.:
        
        /*
         * username.add(new AjaxFormComponentUpdatingBehavior("mousedown"){

            private static final long serialVersionUID = 7839692292638124930L;

            @Override
            protected void onUpdate(AjaxRequestTarget target)
            {
                    //some action
            }
        });
         */
    }
}
