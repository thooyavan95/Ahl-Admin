package com.example.ahladmin.Fragments;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ahladmin.Adapters.TestRecycleAdapter;
import com.example.ahladmin.Entity.TestClass;
import com.example.ahladmin.Interfaces.RecycleListener;
import com.example.ahladmin.Interfaces.ViewInterface;
import com.example.ahladmin.R;
import com.example.ahladmin.Utility.AhlDialogFragment;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MatchUpdateFragment extends Fragment implements ViewInterface, View.OnClickListener {

    private boolean isRunning = false;
    private long pauseOffset;
    private ArrayList<TestClass> arrayList;
//    private TestAdapter adapter;
    private TestRecycleAdapter adapter;

    private String[] dummyNames = {"Player Name 1","Player Name 2","Player Name 3","Player Name 4","Player Name 5"};
    private String[] editItems = {"Edit", "Retry", "Delete"};

    public MatchUpdateFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.admin_panel,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.add_goal).setOnClickListener(this);
        view.findViewById(R.id.add_card).setOnClickListener(this);
        view.findViewById(R.id.start_match).setOnClickListener(this);
        view.findViewById(R.id.end_match).setOnClickListener(this);

        arrayList = new ArrayList<>();

        ((RecyclerView) getView().findViewById(R.id.admin_recycle_view)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) getView().findViewById(R.id.admin_recycle_view)).setHasFixedSize(true);
        ((RecyclerView) getView().findViewById(R.id.admin_recycle_view)).addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        adapter = new TestRecycleAdapter(arrayList, getContext(), new RecycleListener() {
            @Override
            public void OnClickStatusListener(int position) {
                new AhlDialogFragment(editItems,MatchUpdateFragment.this).show(getFragmentManager(),null);
            }
        });

        ((RecyclerView) getView().findViewById(R.id.admin_recycle_view)).setAdapter(adapter);

//        arrayList.add(new TestClass("uploading","name","23'","goal"));
//        arrayList.add(new TestClass("retry","name","23'","card"));
//        arrayList.add(new TestClass("success","name","23'","goal"));
//        arrayList.add(new TestClass("","name","23'","card"));



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.add_goal:

                if(isRunning) {

//                Toast.makeText(getContext(), String.valueOf((SystemClock.elapsedRealtime() - ((Chronometer) getView().findViewById(R.id.match_timer)).getBase()) / 60000), Toast.LENGTH_SHORT).show();

                    new AhlDialogFragment(dummyNames, MatchUpdateFragment.this, "Goal").show(getFragmentManager(), null);

                }
                else
                {
                    Toast.makeText(getContext(), "Timer is not active", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.add_card:

                if(isRunning) {

                    new AhlDialogFragment(dummyNames, MatchUpdateFragment.this, "Card").show(getFragmentManager(), null);
                }
                else
                {
                    Toast.makeText(getContext(), "Timer is not active", Toast.LENGTH_SHORT).show();
                }

                break;


            case R.id.start_match:

                if(!isRunning)
                {
                    ((Chronometer) getView().findViewById(R.id.match_timer)).setBase(SystemClock.elapsedRealtime() - pauseOffset);
                    ((Chronometer) getView().findViewById(R.id.match_timer)).start();
                    ((MaterialButton) getView().findViewById(R.id.start_match)).setText("Pause Match");

                    isRunning = true;
                }
                else
                {
                    ((Chronometer) getView().findViewById(R.id.match_timer)).stop();
                    pauseOffset = SystemClock.elapsedRealtime() - ((Chronometer) getView().findViewById(R.id.match_timer)).getBase();
                    ((MaterialButton) getView().findViewById(R.id.start_match)).setText("Resume Match");

                    isRunning = false;
                }

                break;

            case R.id.end_match:

                    ((Chronometer) getView().findViewById(R.id.match_timer)).stop();
                    ((MaterialButton) getView().findViewById(R.id.start_match)).setText("Start Match");
                    pauseOffset = 0;

                    isRunning = false;

                break;

        }
    }

    @Override
    public void itemSelected(String item,String type) {


        String min = (SystemClock.elapsedRealtime() - ((Chronometer) getView().findViewById(R.id.match_timer)).getBase()) / 60000 + "'";
        String status = "Updating...";

        arrayList.add(new TestClass(status,item,min,type));
        adapter.arrayList = arrayList;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void dialogSlected(String selectedItem) {
        Toast.makeText(getContext(), "Selected item is " + selectedItem, Toast.LENGTH_SHORT).show();
    }

}
