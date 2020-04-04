package com.test.calorie;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDbHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceCalories;
    private List<Calorie> calories = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Calorie> calories, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDbHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceCalories = mDatabase.getReference("calories");
    }

    public void readCalories(final DataStatus dataStatus) {
        mReferenceCalories.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                calories.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Calorie calorie = keyNode.getValue(Calorie.class);
                    calories.add(calorie);
                }
                dataStatus.DataIsLoaded(calories,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
