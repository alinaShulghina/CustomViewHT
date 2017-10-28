package com.example.alin_.customviewht.enter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.alin_.customviewht.Contact;
import com.example.alin_.customviewht.contacts.ContactsActivity;
import com.example.alin_.customviewht.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<Contact> contacts;
    private LinearLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contacts = new ArrayList<>();
        rootView = findViewById(R.id.ll_main);
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onNameEnteredEvent(EnterNameEvent event){
        contacts.add(new Contact(event.getEnteredName()));
        rootView.addView(event.getView());
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_save:
                startActivity(ContactsActivity.newIntent(this,(ArrayList<Contact>) contacts));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
