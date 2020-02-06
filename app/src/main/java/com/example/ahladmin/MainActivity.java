package com.example.ahladmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.example.ahladmin.Fragments.MatchUpdateFragment;
import com.example.ahladmin.Fragments.TestFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_activity_container, new TestFragment())
                    .commit();
        }

    }
}
