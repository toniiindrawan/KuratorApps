package com.kurio.kurator.kuratorapps;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {
    Button buttonLogin;
    EditText textUsername;
    EditText textPassword;
    TextView textWarning;
    ImageView imageWarning;
    private android.support.v7.app.ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //    actionBar.setHomeButtonEnabled(true);

        actionBar.hide();

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        textUsername = (EditText) findViewById(R.id.textUsername);
        textPassword = (EditText) findViewById(R.id.textPassword);
        textWarning=(TextView) findViewById(R.id.textWarning);
        imageWarning=(ImageView)findViewById(R.id.imageWarning);
        textWarning.setVisibility(View.INVISIBLE);
        imageWarning.setVisibility(View.INVISIBLE);
        setOnClickLoginButton();
     //   setOnClickShowPassword();
    }

    private void setOnClickLoginButton() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textUsername.getText().toString().equalsIgnoreCase("admin") && textPassword.getText().toString().equalsIgnoreCase("admin")) {

                    Intent i = new Intent(view.getContext(), LoginActivity.class);
                    startActivity(i);


                } else {
                    Toast.makeText(getApplicationContext(), "username and/or password didn't match", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
/*
    private void setOnClickShowPassword() {
        textPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (event.getRawX() >= (textPassword.getRight() - textPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {


                        textPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                        return true;
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (textPassword.getRight() - textPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {


                        textPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        return true;
                    }
                }
                return false;
            }
        });
    }

*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
