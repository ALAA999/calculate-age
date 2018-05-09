package com.example.alaa.calculateyourage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {
    String year_of_born;
    CheckBox box;
    static int boxcheck;
    CardView calculate_btn;
    String month_of_born;
    EditText editText1, editText2, editText3, editText4, editText5, editText6;
    String day_of_born;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        boxcheck = 0;
        View view = inflater.inflate(R.layout.fragment1, container, false);
        box = view.findViewById(R.id.box);
        calculate_btn = view.findViewById(R.id.calculate);
        editText1 = view.findViewById(R.id.year);
        editText2 = view.findViewById(R.id.month);
        editText3 = view.findViewById(R.id.day);
        editText4 = view.findViewById(R.id.year_alt);
        editText4.setEnabled(false);
        editText5 = view.findViewById(R.id.month_alt);
        editText5.setEnabled(false);
        editText6 = view.findViewById(R.id.day_alt);
        editText6.setEnabled(false);
        box.setOnClickListener(Fragment1.this);
        calculate_btn.setOnClickListener(Fragment1.this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == box) {
            if (boxcheck == 0) {
                editText4.setBackgroundResource(R.drawable.backs);
                editText5.setBackgroundResource(R.drawable.backs);
                editText6.setBackgroundResource(R.drawable.backs);
                editText4.setEnabled(true);
                editText5.setEnabled(true);
                editText6.setEnabled(true);
                editText4.setHint("Current Year...");
                editText5.setHint("Current Month...");
                editText6.setHint("Current Day...");
                ++boxcheck;
            } else {
                editText4.setBackgroundResource(R.drawable.backdark);
                editText5.setBackgroundResource(R.drawable.backdark);
                editText6.setBackgroundResource(R.drawable.backdark);
                editText4.setEnabled(false);
                editText5.setEnabled(false);
                editText6.setEnabled(false);
                editText4.setHint("");
                editText5.setHint("");
                editText6.setHint("");
                --boxcheck;
            }
        }
        if (view == calculate_btn) {
            year_of_born = editText1.getText().toString();
            month_of_born = editText2.getText().toString();
            day_of_born = editText3.getText().toString();
            if (year_of_born.equals("") || day_of_born.equals("") || month_of_born.equals("")) {
                Toast.makeText(getActivity(), "Fill up all EditTexts!", Toast.LENGTH_SHORT).show();
            } else {
                int year_Of_Born = Integer.parseInt(year_of_born);
                int month_Of_Born = Integer.parseInt(month_of_born);
                int day_Of_Born = Integer.parseInt(day_of_born);
                ShowAge showAge = new ShowAge();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.first_linear, showAge);
                Bundle b = new Bundle();
                b.putInt("year", year_Of_Born);
                b.putInt("month", month_Of_Born);
                b.putInt("day", day_Of_Born);
                if (boxcheck != 0) {
                    int current_year = Integer.parseInt(editText4.getText().toString());
                    int current_month = Integer.parseInt(editText5.getText().toString());
                    int current_day = Integer.parseInt(editText6.getText().toString());
                    b.putInt("year_current", current_year);
                    b.putInt("month_current", current_month);
                    b.putInt("day_current", current_day);
                }
                showAge.setArguments(b);
                transaction.commit();
            }
        }
    }
}