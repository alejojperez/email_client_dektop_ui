package com.github.alejojperez.email_client_desktop_ui.presenters;

import com.github.alejojperez.email_client_desktop_ui.App;
import com.github.alejojperez.email_client_desktop_ui.core.contracts.IPresenter;
import com.github.alejojperez.email_client_desktop_ui.views.EmailsView;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class EmailsViewPresenter implements IPresenter
{
    public void show()
    {
        Stage stage = App.getGlobalStage();

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());

        stage.setMinWidth(800);
        stage.setMinHeight(600);

        stage.setTitle("Email Client");
        ViewTuple viewTuple = FluentViewLoader.fxmlView(EmailsView.class).load();

        Parent root = viewTuple.getView();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
