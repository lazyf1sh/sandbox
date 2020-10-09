package com.github.lazyf1sh.sandbox.wicket.examples.js;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnLoadHeaderItem;
import org.apache.wicket.markup.html.WebPage;

public class JsRenderOnLoadHeaderItem extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        ModalWindow callSubpanelDialog = new ModalWindow("subpanelModalWindow");
        callSubpanelDialog.setOutputMarkupId(true);
        add(callSubpanelDialog);

        add(new AjaxLink<Void>("callSubpanelDialog")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                JsRenderOnLoadHeaderItemPanel subPanel = new JsRenderOnLoadHeaderItemPanel(callSubpanelDialog.getContentId());
                subPanel.setOutputMarkupId(true);
                callSubpanelDialog.setContent(subPanel);
                callSubpanelDialog.show(target);
            }
        });
    }

    @Override
    public void renderHead(IHeaderResponse response)
    {
        super.renderHead(response);
        response.render(new OnLoadHeaderItem("alert('OnLoadHeaderItem - page.')"));
    }
}
