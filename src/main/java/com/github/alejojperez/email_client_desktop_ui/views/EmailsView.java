package com.github.alejojperez.email_client_desktop_ui.views;

import com.github.alejojperez.email_client_data.entities.AccountCredential;
import com.github.alejojperez.email_client_desktop_ui.view_models.EmailsViewModel;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.collections.MapChangeListener;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class EmailsView implements FxmlView<EmailsViewModel>, Initializable
{
    /**
     * No accounts view variables
     */

    //////////// FXML ////////////////
    public AnchorPane apNoAccountsContainer;

    /**
     * Emails view variables
     */

    //////////// FXML ////////////////
    public AnchorPane apEmailsContainer;
    public ProgressIndicator piMailBoxes;
    public TreeItem tiMailboxesArchive;
    public TreeItem tiMailboxesDrafts;
    public TreeItem tiMailboxesInbox;
    public TreeItem tiMailboxesJunk;
    public TreeItem tiMailboxesSent;
    public TreeItem tiMailboxesTrash;

    @InjectViewModel
    private EmailsViewModel viewModel;

    public void initialize(URL location, ResourceBundle resources)
    {
        this.bindViewModel();
    }

    //<editor-fold desc="Bind View Model">

    public void bindViewModel()
    {
        this.bindViewModelMailboxes();
    }

    public void bindViewModelMailboxes()
    {
        this.viewModel.accountCredentials.addListener((MapChangeListener<String, AccountCredential>) change ->
        {
            tiMailboxesArchive.getChildren().clear();
            tiMailboxesDrafts.getChildren().clear();
            tiMailboxesInbox.getChildren().clear();
            tiMailboxesJunk.getChildren().clear();
            tiMailboxesSent.getChildren().clear();
            tiMailboxesTrash.getChildren().clear();

            for(AccountCredential credential: viewModel.accountCredentials.values())
            {
                tiMailboxesArchive.getChildren().add(new TreeItem(credential.getString("alias")));
                tiMailboxesDrafts.getChildren().add(new TreeItem(credential.getString("alias")));
                tiMailboxesInbox.getChildren().add(new TreeItem(credential.getString("alias")));
                tiMailboxesJunk.getChildren().add(new TreeItem(credential.getString("alias")));
                tiMailboxesSent.getChildren().add(new TreeItem(credential.getString("alias")));
                tiMailboxesTrash.getChildren().add(new TreeItem(credential.getString("alias")));
            }
        });
    }

    public void bindViewModelViewsVisibility()
    {
//        this.apEmailsContainer.visibleProperty().bind(this.viewModel.accountCredentials.);
    }

    //</editor-fold>
}
