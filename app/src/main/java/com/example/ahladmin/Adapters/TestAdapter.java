package com.example.ahladmin.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ahladmin.Entity.TestClass;
import com.example.ahladmin.R;

import java.util.ArrayList;

public class TestAdapter extends ArrayAdapter<TestClass> {

    public TestAdapter(@NonNull Context context, @NonNull ArrayList<TestClass> objects) {
        super(context, 0, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.admin_row_status,parent,false);
        }

        TestClass obj = getItem(position);

        TextView name,min,type,status;

        name = convertView.findViewById(R.id.admin_update_status_player_name);
        min = convertView.findViewById(R.id.admin_update_status_minute);
        type = convertView.findViewById(R.id.admin_update_status_type);
        status = convertView.findViewById(R.id.admin_update_status);

        status.setVisibility(View.GONE);

        name.setText(obj.getPlayerName());
        min.setText(obj.getMinute());
        type.setText(obj.getType());
        status.setText(obj.getStatus());

        return convertView;

    }
}
