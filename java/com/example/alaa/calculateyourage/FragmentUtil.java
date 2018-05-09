package com.example.alaa.calculateyourage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Alaa on 11/23/2017.
 */

public class FragmentUtil {
    public static void addFragment(Context context, Fragment fragment, int layout){

        FragmentManager manager = ((FragmentActivity)context).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(layout,fragment);
        transaction.commit();
    }
    //Replace Activity to Fragment and Send Data From Activity to Fragment

    public static void addFragment(Context context, Fragment fragment, int layout, Bundle bundle){
        fragment.setArguments(bundle);
        FragmentManager manager = ((FragmentActivity)context).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(layout,fragment);
        transaction.commit();
    }

    //Replace Activity to Fragment and Access To Button Back

    public static void addFragmentWithBackStack(Context context, Fragment fragment, int layout){
        FragmentManager manager = ((FragmentActivity)context).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(layout,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    //Replace Activity to Fragment and Access To Button Back and Send Data

    public static void addFragmentWithBackStack(Context context, Fragment fragment, int layout, Bundle bundle){
        fragment.setArguments(bundle);
        FragmentManager manager = ((FragmentActivity)context).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(layout,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    //Replace Fragment to Fragment

    public static void replaceFragment(Context context, Fragment fragment, int layout){
        ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(layout,fragment).commit();
    }
    //Replace Fragment to Fragment And Send Data

    public static void replaceFragment(Context context, Fragment fragment, int layout, Bundle bundle){
        fragment.setArguments(bundle);
        ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(layout,fragment).commit();
    }

    public static void replaceFragmentWithBackStack(Context context, Fragment fragment, int layout){
        ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(layout,fragment).addToBackStack(null).commit();
    }

    public static void replaceFragmentWithBackStack(Context context, Fragment fragment, int layout, Bundle bundle){
        fragment.setArguments(bundle);
        ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(layout,fragment).addToBackStack(null).commit();
    }
}
