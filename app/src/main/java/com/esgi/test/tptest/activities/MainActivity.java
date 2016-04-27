package com.esgi.test.tptest.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.esgi.test.tptest.R;
import com.esgi.test.tptest.model.SimpleObject;
import com.esgi.test.tptest.receivers.MyReceiver;
import com.esgi.test.tptest.touchwithcare.Constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String NEW_MAX_VALUE = "NEW_MAX_VALUE";
    List<SimpleObject> simpleObjects = new ArrayList<>();
    int max = 0;
    MyReceiver myReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myReceiver = new MyReceiver();
        registerReceiver(myReceiver, new IntentFilter(NEW_MAX_VALUE));
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecondActivity();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startThirdActivity();
            }
        });
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFourthActivity();
            }
        });

    }

    private void startSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(Constants.MAX, max);
        startActivityForResult(intent, Constants.REQUEST_CODE_FOR_SECOND_ACTIVITY);
    }

    private void startThirdActivity() {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra(Constants.DATA, (Serializable) simpleObjects);
        startActivityForResult(intent, Constants.REQUEST_CODE_FOR_SECOND_ACTIVITY);
    }

    private void startFourthActivity() {
        Intent intent = new Intent(this, FourthActivity.class);
        intent.putExtra(Constants.DATA, (Serializable) simpleObjects);
        startActivityForResult(intent, Constants.REQUEST_CODE_FOR_SECOND_ACTIVITY);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_CODE_FOR_SECOND_ACTIVITY) {
            if (resultCode == RESULT_OK) {
                if (null != data) {
                    int value = data.getIntExtra(Constants.SCORE, -1);
                    simpleObjects.add(new SimpleObject(value, new Date()));
                    if (value > max) {
                        max = value;
                        Intent intent = new Intent(NEW_MAX_VALUE);
                        intent.putExtra(Constants.MAX, max);
                        sendBroadcast(intent);
                    }
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
