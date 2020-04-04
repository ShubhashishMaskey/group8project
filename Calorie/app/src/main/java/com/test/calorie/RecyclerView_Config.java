package com.test.calorie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private CaloriesAdapter mCaloriesAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Calorie> calories, List<String> keys) {
        mContext = context;
        mCaloriesAdapter = new CaloriesAdapter(calories, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mCaloriesAdapter);
    }

    class CalorieItemView extends RecyclerView.ViewHolder {
        private TextView mFirstName;
        private TextView mLastName;
        private TextView mPhone;
        private TextView mDescription;

        private String key;

        public CalorieItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.calorie_list_item, parent, false));
            mFirstName = (TextView) itemView.findViewById(R.id.firstname_txtview);
            mLastName = (TextView) itemView.findViewById(R.id.lastname_txtview);
            mPhone = (TextView) itemView.findViewById(R.id.phone_txtview);
            mDescription = (TextView) itemView.findViewById(R.id.description_txtview);
        }

        public void bind(Calorie calorie, String key) {
            mFirstName.setText(calorie.getFirstname());
            mLastName.setText(calorie.getLastname());
            mPhone.setText(calorie.getPhone());
            mDescription.setText(calorie.getDescription());
            this.key = key;
        }
    }
    class CaloriesAdapter extends RecyclerView.Adapter<CalorieItemView> {
        private List<Calorie> mCalorieList;
        private List<String> mKeys;

        public CaloriesAdapter(List<Calorie> mCalorieList, List<String> mKeys) {
            this.mCalorieList = mCalorieList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public CalorieItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CalorieItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CalorieItemView holder, int position) {
            holder.bind(mCalorieList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mCalorieList.size();
        }
    }
}
