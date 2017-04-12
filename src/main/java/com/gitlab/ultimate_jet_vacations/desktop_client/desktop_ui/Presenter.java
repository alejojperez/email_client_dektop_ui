package com.gitlab.ultimate_jet_vacations.desktop_client.desktop_ui;

import com.gitlab.ultimate_jet_vacations.desktop_client.desktop_ui.core.contracts.IPresenter;
import com.gitlab.ultimate_jet_vacations.desktop_client.desktop_ui.view_models.EmailsViewModel;
import com.gitlab.ultimate_jet_vacations.desktop_client.desktop_ui.views.EmailsView;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Presenter implements IPresenter
{
    public void show()
    {
        Stage stage = new Stage();

        stage.setMinWidth(300);
        stage.setMinHeight(100);

        stage.setTitle("Ultimate Jet Vacations");
        ViewTuple viewTuple = FluentViewLoader.fxmlView(EmailsView.class).load();

        Parent root = viewTuple.getView();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
