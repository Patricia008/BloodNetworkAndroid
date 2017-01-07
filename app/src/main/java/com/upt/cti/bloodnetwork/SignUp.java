package com.upt.cti.bloodnetwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void clicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.signup:
//                intent = new Intent(this, SignUp.class);
//                startActivity(intent);
                break;
        }
    }
}
