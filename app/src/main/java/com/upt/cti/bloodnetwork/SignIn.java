package com.upt.cti.bloodnetwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void clicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.signup:
                intent = new Intent(this, SignUp.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                intent = new Intent(this, Menu.class);
                startActivity(intent);
                break;
        }
    }
}
