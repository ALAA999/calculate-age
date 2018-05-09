package com.example.alaa.calculateyourage;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class splashscreen extends Fragment {


    public splashscreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_splashscreen, container, false);
        new CountDownTimer(2000, 2000) {
            public void onTick(long millisUntilFinished) {
            }//Thread.sleep dose not work here

            public void onFinish() {
                Fragment1 fragment1 = new Fragment1();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.first_linear, fragment1);
                transaction.commit();
            }
        }.start();
        return view;
    }
}