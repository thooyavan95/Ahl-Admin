package com.example.ahladmin.Entity;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ahladmin.Interfaces.RecycleListener;
import com.example.ahladmin.R;

public class TestViewHolder extends RecyclerView.ViewHolder {

    public TextView name,minute,type,status;

    public TestViewHolder(@NonNull View itemView, final RecycleListener listener) {
        super(itemView);

        name = itemView.findViewById(R.id.admin_update_status_player_name);
        minute = itemView.findViewById(R.id.admin_update_status_minute);
        type = itemView.findViewById(R.id.admin_update_status_type);
        status = itemView.findViewById(R.id.admin_update_status);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null) {
                    int positon = getAdapterPosition();
                    if(positon != RecyclerView.NO_POSITION) {
                        listener.OnClickStatusListener(positon);
                    }
                }
            }
        });

    }
}
