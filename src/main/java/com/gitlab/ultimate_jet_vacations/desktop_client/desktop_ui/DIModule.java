package com.gitlab.ultimate_jet_vacations.desktop_client.desktop_ui;

import com.gitlab.ultimate_jet_vacations.desktop_client.desktop_ui.core.contracts.IPresenter;
import com.google.inject.AbstractModule;

public class DIModule extends AbstractModule
{
    protected void configure()
    {
        this.bind(IPresenter.class).to(Presenter.class);
    }
}
