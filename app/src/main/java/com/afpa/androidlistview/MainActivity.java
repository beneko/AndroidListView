package com.afpa.androidlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import model.UserAccount;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération de listview
        ListView listView = (ListView)findViewById(R.id.listView);
        //Création des users
        UserAccount francois = new UserAccount("François","admin");
        UserAccount germain = new UserAccount("Germain","user");
        UserAccount cedric = new UserAccount("Cédric","guest",false);
        //Création de la liste
                UserAccount[] users = new UserAccount[]{francois,germain,cedric};
        //Création de l'adapter
                ArrayAdapter<UserAccount> arrayAdapter = new ArrayAdapter<UserAccount>(this, android.R.layout.simple_list_item_1,users);
        //Affectation de l'adapter
                listView.setAdapter(arrayAdapter);
    }
}