package com.example.jessicairving.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        //Gets user input
        EditText userInputField = (EditText) findViewById(R.id.userInputField);
        String message = userInputField.getText().toString();

        //Passing string through Validator
        Validator val = new Validator();
        val.setPassword(message);

        int passed = val.validate();
        String strength = "";

        if (passed < 4) {
            strength = "weak";
        } else if (passed >=4 && passed < 6){
            strength = "okay";
        } else {
            strength = "strong";
        }

        //Updates text with user input
        TextView strengthDisplay = (TextView) findViewById(R.id.strengthDisplay);
        strengthDisplay.setText("Your password is " + strength);
    }
}
