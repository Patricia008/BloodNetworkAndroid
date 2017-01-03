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
        switch (view.getId()) {
            case R.id.signIn:
                Intent intent = new Intent(this, SignIn.class);
                //EditText editText = (EditText) findViewById(R.id.edit_message);
                //String message = editText.getText().toString();
                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                break;
//            case R.id.bUpdate:
//                databaseReference.child("calendar").child("march").child("expenses").setValue(eIncome.getText());
//                databaseReference.child("calendar").child("march").child("income").setValue(eExpenses.getText());
//                break;
        }
    }
}
