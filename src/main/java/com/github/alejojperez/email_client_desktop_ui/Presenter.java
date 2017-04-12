package com.github.alejojperez.email_client_desktop_ui;

import com.github.alejojperez.email_client_desktop_ui.core.contracts.IPresenter;
import com.github.alejojperez.email_client_desktop_ui.views.EmailsView;
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
