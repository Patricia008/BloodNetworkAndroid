package com.upt.cti.bloodnetwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void clicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.nearest:
                intent = new Intent(this, Nearest.class);
                startActivity(intent);
                break;
            case R.id.priority:
                intent = new Intent(this, Priority.class);
                startActivity(intent);
                break;
            case R.id.history:
                intent = new Intent(this, History.class);
                startActivity(intent);
                break;
        }
    }
}
