package com.upt.cti.bloodnetwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.signin:
                intent = new Intent(this, SignIn.class);
                startActivity(intent);
                break;
            case R.id.skipsignin:
                intent = new Intent(this, Menu.class);
                startActivity(intent);
                break;
        }
    }
}
