package com.github.lazyf1sh.sandbox.wicket.examples.prototypes.docdialog;

import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;

public class MyModalWindow extends ModalWindow
{
    private static final long serialVersionUID = -4307944963703291701L;

    public MyModalWindow(String id)
    {
        super(id);
        setContent(new com.github.lazyf1sh.sandbox.wicket.examples.prototypes.docdialog.MyModalWindowContent(getContentId()));
    }
}
