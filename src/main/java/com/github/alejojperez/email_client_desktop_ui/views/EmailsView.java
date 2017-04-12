package com.github.alejojperez.email_client_desktop_ui.views;

import com.github.alejojperez.email_client_desktop_ui.view_models.EmailsViewModel;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TreeItem;

import java.net.URL;
import java.util.ResourceBundle;

public class EmailsView implements FxmlView<EmailsViewModel>, Initializable
{
    public ProgressIndicator piMailBoxes;
    public TreeItem tiMailboxesInbox;
    public TreeItem tiMailboxesDrafts;
    public TreeItem tiMailboxesSent;
    public TreeItem tiMailboxesJunk;
    public TreeItem tiMailboxesTrash;
    public TreeItem tiMailboxesArchive;

    @InjectViewModel
    private EmailsViewModel viewModel;

    public void initialize(URL location, ResourceBundle resources)
    {
        this.refreshMailBoxes();
    }

    //<editor-fold desc="Initialize">

    public void refreshMailBoxes()
    {
        this.tiMailboxesInbox.getChildren().add(new TreeItem<String>("Ultimate Jet Vacations"));
    }

    //</editor-fold>
}
