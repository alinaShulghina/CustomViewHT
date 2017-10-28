package com.example.alin_.customviewht.contacts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alin_.customviewht.Contact;
import com.example.alin_.customviewht.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alin- on 28.10.2017.
 */

public class ContactsActivity extends AppCompatActivity {
    public static final String CONTACTS_TAG = "Contacts";
    private List<Contact> contacts;
    private RecyclerView recyclerView;

    public static Intent newIntent(Context context,ArrayList<Contact> contacts) {
        Intent intent = new Intent(context,ContactsActivity.class);
        intent.putExtra(CONTACTS_TAG,contacts);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        init();
    }

    private void init() {
        contacts = new ArrayList<>();
        contacts = (ArrayList<Contact>) getIntent().getExtras().get(CONTACTS_TAG);
        ContactsAdapter adapter = new ContactsAdapter(contacts);
        recyclerView = findViewById(R.id.rv_contacts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}
