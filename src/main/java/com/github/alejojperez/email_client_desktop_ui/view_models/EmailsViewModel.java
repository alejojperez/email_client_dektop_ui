package com.github.alejojperez.email_client_desktop_ui.view_models;

import com.github.alejojperez.email_client_data.connections.CredentialsConnection;
import com.github.alejojperez.email_client_data.entities.AccountCredential;
import de.saxsys.mvvmfx.ViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import java.util.List;

public class EmailsViewModel implements ViewModel
{
    public ObservableMap<String, AccountCredential> accountCredentials = FXCollections.observableHashMap();

    public EmailsViewModel()
    {
        this.loadAll();
    }

    //<editor-fold desc="Load Section">

    public void loadAll()
    {
        this.loadAccountCredentials();
    }

    public void loadAccountCredentials()
    {
        CredentialsConnection.getInstance().open();

        List<AccountCredential> credentials = AccountCredential.findAll();

        for(AccountCredential credential: credentials)
            this.accountCredentials.put(credential.getString("alias"), credential);

        CredentialsConnection.getInstance().close();
    }

    //</editor-fold>
}
