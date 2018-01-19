package com.example.fatma.udacitygradleproject;

import android.test.AndroidTestCase;
import android.util.Log;

import static java.security.AccessController.getContext;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by prins on 1/19/2018.
 */

public class JokeAsyncTest extends AndroidTestCase {

    private static final String LOG_TAG = "JokeAsyncTest";

    @SuppressWarnings("unchecked")
    public void test() {
        String result = null;
        JokeAsyncTask jokeAsyncTask = new JokeAsyncTask(getContext(), null);
        jokeAsyncTask.execute();
        try {
            result = jokeAsyncTask.get();
            Log.d(LOG_TAG, "none empty joke " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }

}