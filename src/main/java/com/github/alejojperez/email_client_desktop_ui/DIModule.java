package com.github.alejojperez.email_client_desktop_ui;

import com.github.alejojperez.email_client_desktop_ui.core.contracts.IPresenter;
import com.google.inject.AbstractModule;

public class DIModule extends AbstractModule
{
    protected void configure()
    {
        this.bind(IPresenter.class).to(Presenter.class);
    }
}
