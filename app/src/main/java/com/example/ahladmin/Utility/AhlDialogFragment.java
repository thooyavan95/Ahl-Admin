package com.example.ahladmin.Utility;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.ahladmin.Adapters.TestAdapter;
import com.example.ahladmin.Interfaces.ViewInterface;
import com.example.ahladmin.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class AhlDialogFragment extends DialogFragment {


    private TestAdapter spinnerItems;
    private ViewInterface viewInterface;
    private boolean isStatus;
    private String type;

    private String[] dialogItems;
    private String[] editItems;

//    public AhlDialogFragment(TestAdapter spinnerItems,ViewInterface viewInterface) {
//        this.spinnerItems = spinnerItems;
//        this.viewInterface = viewInterface;
//        isStatus = true;
//    }


    public AhlDialogFragment(String[] editItems, ViewInterface viewInterface)
    {
        this.editItems = editItems;
        this.viewInterface = viewInterface;
        isStatus = true;
    }

    public AhlDialogFragment(String[] dialogItems, ViewInterface viewInterface,String type)
    {
        this.dialogItems = dialogItems;
        this.viewInterface = viewInterface;
        this.type = type;
        isStatus = false;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.admin_row_status,container,false);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(getActivity());

        if(isStatus) {
//            dialogBuilder.setAdapter(spinnerItems, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    viewInterface.itemSelected();
//                }
//            });
//
//            return dialogBuilder.create();

            dialogBuilder.setItems(editItems, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    viewInterface.dialogSlected(editItems[i]);
                }
            });

            return dialogBuilder.create();
        }


        else
        {
            dialogBuilder.setItems(dialogItems, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    viewInterface.itemSelected(dialogItems[i],type);
                }
            });

            return dialogBuilder.create();
        }
    }
}
