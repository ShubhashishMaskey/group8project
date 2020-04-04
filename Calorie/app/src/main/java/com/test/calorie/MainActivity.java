package com.test.calorie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_calories);
        new FirebaseDbHelper().readCalories(new FirebaseDbHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Calorie> calories, List<String> keys) {
                findViewById(R.id.loading_coaches).setVisibility(View.GONE);
                new RecyclerView_Config().setConfig(mRecyclerView, MainActivity.this, calories, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}
