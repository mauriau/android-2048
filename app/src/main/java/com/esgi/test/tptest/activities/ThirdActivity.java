package com.esgi.test.tptest.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.esgi.test.tptest.R;
import com.esgi.test.tptest.adapter.SimpleAdapter;
import com.esgi.test.tptest.model.SimpleObject;
import com.esgi.test.tptest.touchwithcare.Constants;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        int max = getIntent().getIntExtra(Constants.MAX, -1);

        List<SimpleObject> list = (List<SimpleObject>) getIntent().getSerializableExtra(Constants.DATA);

        //Order the list maybe
        ArrayAdapter<SimpleObject> adapter = new ArrayAdapter<SimpleObject>(this, android.R.layout.simple_list_item_1,list);
        List<SimpleObject> simpleObjects = new ArrayList<>();

/*        SimpleAdapter simpleAdapter = new SimpleAdapter(this, simpleObjects);
        setListAdapter(simpleAdapter);*/
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //Do Somthing like SHARE !!
        super.onListItemClick(l, v, position, id);

        SimpleObject current = (SimpleObject) getListAdapter().getItem(position);
    }
}
