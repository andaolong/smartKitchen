package com.example.smartKitchen.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.smartKitchen.GainMuscleActivity;
import com.example.smartKitchen.LoseWeightActivity;
import com.example.smartKitchen.R;
import com.example.smartKitchen.ShapingActivity;
import com.example.smartKitchen.SmartActivity;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ConstraintLayout lose_weight = root.findViewById(R.id.lose_weight);
        ConstraintLayout shaping = root.findViewById(R.id.shaping);
        ConstraintLayout gain_muscle = root.findViewById(R.id.gain_muscle);
        ConstraintLayout smart = root.findViewById(R.id.smart);

        lose_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoseWeightActivity.class);
                startActivity(intent);
            }
        });
        shaping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShapingActivity.class);
                startActivity(intent);
            }
        });
        gain_muscle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GainMuscleActivity.class);
                startActivity(intent);
            }
        });
        smart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SmartActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}