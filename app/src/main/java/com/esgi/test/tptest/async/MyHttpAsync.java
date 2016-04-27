package com.esgi.test.tptest.async;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.esgi.test.tptest.touchwithcare.Utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyHttpAsync extends AsyncTask<String, Void, String> {
    public static final String TAG = "TOTO";
    TextView textView;
    ProgressBar progressBar;

    public MyHttpAsync(TextView textView, ProgressBar progressBar) {
        this.textView = textView;
        this.progressBar = progressBar;
    }

    @Override
    protected String doInBackground(String... params) {
        String urlString = params[0];
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            int status = conn.getResponseCode();
            if (200 == status) {
                InputStream inputStream = conn.getInputStream();
                String toReturn = Utils.getNeededString(inputStream);

                inputStream.close();

                conn.disconnect();

                Thread.sleep(1000);
                return toReturn;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error occured", e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        progressBar.setVisibility(View.GONE);
        textView.setText(s);
    }
}
