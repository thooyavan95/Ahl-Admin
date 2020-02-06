package com.example.ahladmin.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ahladmin.Entity.TestClass;
import com.example.ahladmin.Entity.TestViewHolder;
import com.example.ahladmin.Interfaces.RecycleListener;
import com.example.ahladmin.R;

import java.util.ArrayList;

public class TestRecycleAdapter extends RecyclerView.Adapter<TestViewHolder> {

    public ArrayList<TestClass> arrayList;
    private Context context;
    private RecycleListener listener;

    public TestRecycleAdapter(ArrayList<TestClass> arrayList, Context context, RecycleListener listener) {
        this.arrayList = arrayList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.admin_row_status, parent, false);
        return new TestViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {

        holder.name.setText(arrayList.get(position).getPlayerName());
        holder.minute.setText(arrayList.get(position).getMinute());
        holder.type.setText(arrayList.get(position).getType());
        holder.status.setText(arrayList.get(position).getStatus());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
