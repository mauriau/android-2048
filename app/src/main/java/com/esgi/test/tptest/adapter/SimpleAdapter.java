package com.esgi.test.tptest.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.esgi.test.tptest.model.SimpleObject;

/**
 * Created by sparttan on 25/03/2016.
 */
public class SimpleAdapter extends ArrayAdapter<SimpleObject>{

    public SimpleAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
