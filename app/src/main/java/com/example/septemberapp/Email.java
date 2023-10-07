package com.example.septemberapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class Email extends Activity implements View.OnClickListener {

    EditText personalEmail, intro, personsName, stupidThings, hatefulAction, outro;
    String emailAdd, beggining, name, stupidAction, hatefulAct, out;
    Button sendEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        initializeVars();
        sendEmail.setOnClickListener(this);
    }

    private void initializeVars() {
        personalEmail= (EditText) findViewById(R.id.personalEmail);
        intro= (EditText) findViewById(R.id.intro);
        personsName = (EditText) findViewById(R.id.personsName);
        stupidThings= (EditText) findViewById(R.id.stupidThings);
        hatefulAction= (EditText) findViewById(R.id.hatefulAction);
        outro= (EditText) findViewById(R.id.outro);
        sendEmail= (Button) findViewById(R.id.sendEmail); ;
    }

    @Override
    public void onClick(View v) {
    convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated();
    String emailaddress[] = {emailAdd};
    String message = "Well hello " + name + " I just want to say " + beggining +
            ". Not only that but I hate when you " + stupidAction +
            ", that just really makes me crazy. I just want to make you "+ hatefulAct +
            ". Welp, Thats all i wanted to chit-chatter about, oh and " +out +
            ". Oh also if you get bored you should check out www.mybringback " + '\n' +
            "P.S. I think I love you ....";
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL,emailaddress);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "I hate you!");
        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(emailIntent);
    }

    private void convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated() {
        emailAdd =personalEmail.getText().toString();
        beggining=intro.getText().toString();
        name=personsName.getText().toString();
        stupidAction=stupidThings.getText().toString();
        hatefulAct=hatefulAction.getText().toString();
        out=outro.getText().toString();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
