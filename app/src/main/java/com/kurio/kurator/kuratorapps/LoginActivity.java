package com.kurio.kurator.kuratorapps;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.buttonLogin) Button buttonLogin;
    @Bind(R.id.textUsername) EditText textUsername;
    @Bind(R.id.textPassword) EditText textPassword;
    @Bind(R.id.textWarning) TextView textWarning;
    @Bind(R.id.imageWarning) ImageView imageWarning;

    @OnClick(R.id.buttonLogin)  void setOnClickLoginButton(View view)
    {
        if (textUsername.getText().toString().equalsIgnoreCase("admin") && textPassword.getText().toString().equalsIgnoreCase("admin")) {

            textWarning.setVisibility(View.INVISIBLE);
            imageWarning.setVisibility(View.INVISIBLE);
            Intent i = new Intent(view.getContext(), MenuActivity.class);
            startActivity(i);
        } else {
            textWarning.setVisibility(View.VISIBLE);
            imageWarning.setVisibility(View.VISIBLE);
        }
    }

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        actionBar = getSupportActionBar();
        actionBar.hide();

        textWarning.setVisibility(View.INVISIBLE);
        imageWarning.setVisibility(View.INVISIBLE);
    }
}
