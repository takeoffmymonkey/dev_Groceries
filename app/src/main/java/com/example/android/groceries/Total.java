package com.example.android.groceries;

import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by takeoff on 006 06 May 17.
 */

public class Total {

    static DecimalFormat decimalFormat = new DecimalFormat("#.##");


    static public void calcTotal(ArrayList<Item> items, TextView textView) {
        double total = 0;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getState()) {
                double t = items.get(i).getTotal(0);
                total += t;
            }
        }
        textView.setText("" + decimalFormat.format(total) + "UAH");
    }
}
