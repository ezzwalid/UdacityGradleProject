package com.example.jokepresenterlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.jokepresenterlib.Contacts.JOKE_KEY;

public class DisplayJokeActivity extends AppCompatActivity {

    TextView jokeTv;
    String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        jokeTv = (TextView) findViewById(R.id.joke_tv);
        joke = getIntent().getStringExtra(JOKE_KEY);
        if (joke != null && joke.length() > 0){
            jokeTv.setText(joke);
        }
        else {
            jokeTv.setText("missing joke!");
        }
    }
}
