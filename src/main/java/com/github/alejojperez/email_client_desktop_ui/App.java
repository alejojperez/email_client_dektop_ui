package com.github.alejojperez.email_client_desktop_ui;

import com.github.alejojperez.email_client_desktop_ui.core.contracts.IPresenter;
import com.github.alejojperez.email_client_desktop_ui.presenters.EmailsViewPresenter;
import com.google.inject.Guice;
import com.google.inject.Injector;
import de.saxsys.mvvmfx.guice.MvvmfxGuiceApplication;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends MvvmfxGuiceApplication
{
    /**
     * Global Stage (window)
     */
    private static Stage globalStage;
    public static Stage getGlobalStage()
    {
        return globalStage;
    }
    public static Stage setGlobalStage(Stage stage)
    {
        App.globalStage = stage;
        return App.getGlobalStage();
    }

    /**
     * Current Dependency Injector module
     */
    private static Injector currentDIModule;
    public static Injector getCurrentDIModule()
    {
        return App.currentDIModule;
    }
    public static Injector setCurrentDIModule(Injector module) { App.currentDIModule = module; return App.getCurrentDIModule(); }

    public static void main(String...args)
    {
        Application.launch(args);
    }

    public void startMvvmfx(Stage stage) throws Exception
    {
        App.setGlobalStage(stage);

        App.setCurrentDIModule( Guice.createInjector(new DIModule()) );
        App.getCurrentDIModule().getInstance(EmailsViewPresenter.class).show();
    }
}

