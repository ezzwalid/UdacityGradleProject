package com.example.fatma.udacitygradleproject;

import android.content.Context;
import android.os.AsyncTask;


import com.example.fatma.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;


import java.io.IOException;



/**
 * Created by prins on 1/16/2018.
 */

public class JokeAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApi = null;

    private Context context;

    AsyncListener asyncListener;



    public JokeAsyncTask(Context context, AsyncListener asyncListener) {
        this.context = context;
        this.asyncListener = asyncListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (asyncListener != null)
            asyncListener.onStartAsync();
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (myApi == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApi = builder.build();
        }

        try {
            return myApi.requestJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


    @Override
    protected void onPostExecute(String s) {
        if (asyncListener != null)
        asyncListener.onFinish(s);
    }

}
