package com.example.alin_.customviewht.enter;

import android.view.View;

/**
 * Created by alin- on 27.10.2017.
 */

public class EnterNameEvent {
    private String enteredName;
    private View view;

    public EnterNameEvent(String enteredName, View view) {
        this.enteredName = enteredName;
        this.view = view;
    }

    public String getEnteredName() {
        return enteredName;
    }

    public View getView(){
        return view;
    }
}
