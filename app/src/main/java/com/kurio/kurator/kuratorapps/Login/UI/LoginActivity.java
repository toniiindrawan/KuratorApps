package com.kurio.kurator.kuratorapps.Login.UI;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kurio.kurator.kuratorapps.Login.ApiLogin.ApiLogin;
import com.kurio.kurator.kuratorapps.Login.Model.Admin;
import com.kurio.kurator.kuratorapps.Login.Model.Flower;
import com.kurio.kurator.kuratorapps.MenuActivity;
import com.kurio.kurator.kuratorapps.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
/*import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
*/
public class LoginActivity extends AppCompatActivity {
    ////////////////////////////////////shared preference////////////////////////////////////
    public SharedPreferences loginToken;
    private final String name = "token";
    public static final int mode = Activity.MODE_PRIVATE;
    ////////////////////////////////////shared preference////////////////////////////////////


    @Bind(R.id.buttonLogin) Button buttonLogin;
    @Bind(R.id.textUsername) EditText textUsername;
    @Bind(R.id.textPassword) EditText textPassword;
    @Bind(R.id.textWarning) TextView textWarning;
    @Bind(R.id.imageWarning) ImageView imageWarning;

    @OnClick(R.id.buttonLogin)  void setOnClickLoginButton(View view) {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /*
        final RestAdapter restadapter = new RestAdapter.Builder().setEndpoint("http://services.hanselandpetal.com").build();

        final ApiLogin apiLogin = restadapter.create(ApiLogin.class);

        apiLogin.getData(new Callback<Admin>() {
            @Override
            public void success(final Admin admin, Response response) {
                if (textUsername.getText().toString().equalsIgnoreCase("admin") && textPassword.getText().toString().equalsIgnoreCase("admin")) {
```


                    textWarning.setVisibility(View.INVISIBLE);
                    imageWarning.setVisibility(View.INVISIBLE);
                    //Intent i = new Intent(view.getContext(), MenuActivity.class);
                    String token; // = token yg didapat dari web service
                     savePreferences(token)

                    Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(i);
                } else {
                    textWarning.setVisibility(View.VISIBLE);
                    imageWarning.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void failure(RetrofitError error) {
                //Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                textWarning.setVisibility(View.VISIBLE);
                imageWarning.setVisibility(View.VISIBLE);
            }
        });
        */
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////


    }

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginToken=getSharedPreferences(name,mode);

        actionBar = getSupportActionBar();
        actionBar.hide();


        textWarning.setVisibility(View.INVISIBLE);
        imageWarning.setVisibility(View.INVISIBLE);
    }

    private void savePreferences(String token)
    {
        SharedPreferences.Editor editor=loginToken.edit();
        editor.putString("token", token);
        editor.apply();
    }
    public void load()
    {
        if(loginToken!=null) {
            String token=loginToken.getString("token","");
            if(token.equalsIgnoreCase("")) {
                SharedPreferences.Editor editor=loginToken.edit();
                editor.putString("token", "");
                editor.apply();
            }
            else
            {
                Intent i = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(i);
                this.finish();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        load();
    }

}
