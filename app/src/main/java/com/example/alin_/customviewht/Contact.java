package com.example.alin_.customviewht;

import java.io.Serializable;

/**
 * Created by alin- on 27.10.2017.
 */

public class Contact implements Serializable {
    private String enteredName;

    public Contact(String enteredName) {
        this.enteredName = enteredName;
    }

    public String getEnteredName() {
        return enteredName;
    }

}
