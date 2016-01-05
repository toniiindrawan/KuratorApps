package com.kurio.kurator.kuratorapps;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.kurio.kurator.kuratorapps.Login.UI.LoginActivity;
import com.kurio.kurator.kuratorapps.R;

public class MenuActivity extends AppCompatActivity {
    public SharedPreferences loginToken;
    private final String name = "token";
    public static final int mode = Activity.MODE_PRIVATE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }
    private void savePreferences(String token)
    {
        SharedPreferences.Editor editor=loginToken.edit();
        editor.putString("token", token);
        editor.apply();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.action_logout:

                this.savePreferences("");
                Intent i = new Intent(this,LoginActivity.class);
                startActivity(i);
                this.finish();
                //   MainActivity.class.finish();
                // android.os.Process.killProcess(android.os.Process.myPid());
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
