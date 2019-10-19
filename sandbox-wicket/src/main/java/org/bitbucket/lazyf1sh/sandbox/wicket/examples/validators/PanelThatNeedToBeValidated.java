package org.bitbucket.lazyf1sh.sandbox.wicket.examples.validators;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Panel - is a container, that holds markup and other components. Usually it is reusable.
 */
public class PanelThatNeedToBeValidated extends Panel
{
    public PanelThatNeedToBeValidated(String id, IModel<?> model)
    {
        super(id, model);
    }
}
