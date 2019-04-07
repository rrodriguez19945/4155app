package com.example.navigationmenu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogInFragment extends Fragment {

    private EditText name;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter = 5;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        name = v.findViewById(R.id.eTName);
        password = v.findViewById(R.id.eTPassword);
        info = v.findViewById(R.id.tVAttempts);
        login = v.findViewById(R.id.btnLogin);

        info.setText("Login attempts left: 5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), password.getText().toString());
            }
        });

        return v;
    }

    private void validate(String userName, String userPassword) {
        if ((userName == "username") && (userPassword == "password")) {
            MyEventsFragment m = new MyEventsFragment();
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.fragment_container, m, m.getTag()).commit();
        }
        else {
            counter--;

            info.setText("Login attempts left: " + String.valueOf(counter));

            if (counter == 0)
                login.setEnabled(false);
        }
    }
}
