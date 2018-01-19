package com.example.fatma.udacitygradleproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.jokepresenterlib.Contacts;
import com.example.jokepresenterlib.DisplayJokeActivity;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity implements AsyncListener{

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading..");
        progressDialog.setCancelable(false);
    }


    public void tellJoke(View view) {
        JokeAsyncTask jokeAsyncTask = new JokeAsyncTask(this, this);
        jokeAsyncTask.execute();
    }


    @Override
    public void onFinish(String joke) {
        progressDialog.dismiss();
        Intent intent = new Intent(this, DisplayJokeActivity.class);
        intent.putExtra(Contacts.JOKE_KEY, joke);
        startActivity(intent);
    }

    @Override
    public void onStartAsync() {
        progressDialog.show();
    }

}
