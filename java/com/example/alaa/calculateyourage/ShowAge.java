package com.example.alaa.calculateyourage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowAge extends Fragment {
    private AdView mAdView;
    int current_year;
    int current_month;
    int current_day;

    public ShowAge() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_age, container, false);

        MobileAds.initialize(getActivity(), "ca-app-pub-1151520966182945~6871390687");
        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Button calculate_again = view.findViewById(R.id.calculate_agein);
        calculate_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment1 showAge = new Fragment1();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.first_linear, showAge);
                transaction.commit();
            }
        });
        Bundle bundle = this.getArguments();
        Calendar c = Calendar.getInstance();
        TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;
        textView1 = view.findViewById(R.id.Age_spent);
        textView2 = view.findViewById(R.id.Age_spent2);
        textView3 = view.findViewById(R.id.Age_hourly);
        textView4 = view.findViewById(R.id.Age_minuts);
        textView5 = view.findViewById(R.id.Age_secound);
        textView6 = view.findViewById(R.id.remaing_next_birth);
        textView7 = view.findViewById(R.id.remaing_next_birth2);
        if (Fragment1.boxcheck == 0) {
            current_year = c.get(Calendar.YEAR);
            current_month = c.get(Calendar.MONTH);
            current_month = current_month + 1;
            current_day = c.get(Calendar.DAY_OF_MONTH);
        } else {
            current_year = bundle.getInt("year_current");
            current_month = bundle.getInt("month_current");
            current_day = bundle.getInt("day_current");
        }

        Toast.makeText(getActivity(), "" + current_year + "/" + current_month + "/" + current_day, Toast.LENGTH_SHORT).show();
        int year_of_born = bundle.getInt("year");
        int month_of_born = bundle.getInt("month");
        int day_of_born = bundle.getInt("day");
        int year_lived = 0;
        int month_lived = 0;
        int day_lived;
        if (current_day >= day_of_born) {
            day_lived = (current_day - day_of_born);
        } else {
            day_lived = 30 - (day_of_born - current_day);
        }
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        if (current_day > day_of_born) {
            month_lived = 12+(current_month - month_of_born);
        } else if (current_day == day_of_born) {
            month_lived = (current_month - month_of_born);
        }else{
            month_lived = 11+(current_month - month_of_born);
        }
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        if (current_month > month_of_born) {
            year_lived = (current_year - year_of_born);
            month_lived = month_lived - 12;
        } else if (current_month == month_of_born && current_day >= day_of_born) {
            year_lived = (current_year - year_of_born);
        } else {
            year_lived = (current_year - year_of_born) - 1;
        }
        int houres_lived = (year_lived * 365 * 24) + (month_lived * 30 * 24) + (day_lived * 24);
        textView1.setText("مضى من عمرك ");
        textView2.setText(year_lived + " سنة " + month_lived + " شهر " + day_lived + " يوم ");
        textView3.setText("مضى من عمرك بالساعات " + "\n" + houres_lived + "ساعة");
        textView4.setText("مضى من عمرك بالدقائق " + "\n" + (houres_lived * 60) + "دقيقة");
        textView5.setText("مضى من عمرك بالثواني " + "\n" + (houres_lived * 60 * 60) + " ثانية ");
        textView6.setText("باقي على عيد ميلادك القادم");
        int month_reamaing, day_reamaing;
        if (current_month > month_of_born) {
            month_reamaing = 11 - (current_month - month_of_born);
        } else {
            month_reamaing = month_of_born - current_month;
        }
        if (current_day > day_of_born) {
            day_reamaing = 30 - (current_day - day_of_born);
        } else {
            day_reamaing = day_of_born - current_day;
        }
        textView7.setText((month_reamaing) + " شهر " + day_reamaing + " يوم");
        return view;
    }

}
