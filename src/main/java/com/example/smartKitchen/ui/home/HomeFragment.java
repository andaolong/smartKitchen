package com.example.smartKitchen.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.smartKitchen.R;
import com.example.smartKitchen.myRefrigeratorFoods;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        //获取到两个点击的设备
        final ConstraintLayout myRefrigerator =root.findViewById(R.id.myRefrigerator);
        final ConstraintLayout myPot = root.findViewById(R.id.myPot);
        //为冰箱和锅子添加点击事件，跳转到其他界面
        myRefrigerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), myRefrigeratorFoods.class);
                startActivity(intent);
            }
        });
        myPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.example.smartKitchen.myPot.class);
                startActivity(intent);
            }
        });





        return root;
    }
}