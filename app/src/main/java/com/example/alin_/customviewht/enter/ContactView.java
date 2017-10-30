package com.example.alin_.customviewht.enter;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;


import com.example.alin_.customviewht.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alin- on 27.10.2017.
 */

public class ContactView extends RelativeLayout {
    private View rootView;
    private EditText et_Name;
    private FloatingActionButton fab_Next;
    private ViewGroup parentView;
    private static List<String> names = new ArrayList<>();

    public ContactView(Context context) {
        super(context);
        init(context);
    }

    public ContactView(Context context, ViewGroup rootView) {
        super(context);
        this.parentView = rootView;
        init(context);
    }

    public ContactView(Context context, AttributeSet attrs,ViewGroup parentView) {
        super(context, attrs);
        this.parentView = parentView;
        init(context);
    }

    private void init(final Context context) {
        rootView = inflate(context, R.layout.contact_view, this);
        et_Name = rootView.findViewById(R.id.et_name);
        et_Name.requestFocus();
        fab_Next = rootView.findViewById(R.id.fab_enter);
        fab_Next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_Name.getText().toString().matches("")) {
                    et_Name.setError(getResources().getString(R.string.error));
                } else {
                    fab_Next.setVisibility(INVISIBLE);
                    et_Name.setFocusableInTouchMode(false);
                    et_Name.setFocusable(false);
                    names.add(et_Name.getText().toString());
                    parentView.addView(new ContactView(getContext(), parentView));
                }
            }
        });
    }


    public static List<String> getNames() {
        return names;
    }
}
