package com.afpa.androidlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import model.UserAccount;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération de listview
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //Création des users
        UserAccount francois = new UserAccount("François","admin");
        UserAccount germain = new UserAccount("Germain","user");
        UserAccount cedric = new UserAccount("Cédric","guest",false);
        UserAccount manu = new UserAccount("Manu","guest");

        //Création de la liste
        List<UserAccount> users = new ArrayList<UserAccount>();
        users.add(francois);
        users.add(germain);
        users.add(cedric);
        users.add(manu);

        //Création de l'adapter
//                ArrayAdapter<UserAccount> arrayAdapter = new ArrayAdapter<UserAccount>(this, android.R.layout.simple_list_item_1,users);
        //Affectation de l'adapter
//                listView.setAdapter(arrayAdapter);


        // utilisation du customListAdapter sur listView
        listView.setAdapter(new CustomListAdapter(users, this));
    }
}