package com.example.android.groceries;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by takeoff on 005 05 May 17.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    ArrayList<Item> items;
    Activity context;


    public ItemAdapter(Activity context, ArrayList<Item> items) {
        super(context, 0, items);
        this.items = items;
        this.context = context;
    }


    @NonNull
    @Override
    // Method has to be overriden it there are not only TextViews in the array
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Item currentItem = getItem(position);

        final int black = Color.BLACK;
        final int gray = Color.GRAY;

        final TextView finalTotalTextView = (TextView) context.findViewById(R.id.total);


        final CheckBox stateView = (CheckBox) listItemView.findViewById(R.id.list_item_state);
        final Button increase = (Button) listItemView.findViewById(R.id.increase_button);
        final TextView amountTextView = (TextView) listItemView.findViewById(R.id.list_item_amount);
        final TextView measureTextView = (TextView) listItemView.findViewById(R.id.list_item_measure);
        final Button decrease = (Button) listItemView.findViewById(R.id.decrease_button);
        final TextView totalTextView = (TextView) listItemView.findViewById(R.id.list_item_total);

        stateView.setChecked(currentItem.getState());
        stateView.setText(currentItem.getName());

        amountTextView.setText(currentItem.getAmount());

        measureTextView.setText(currentItem.getMeasure());

        totalTextView.setText(currentItem.getTotal());

        if (currentItem.getState()) {
            stateView.setTextColor(black);
            amountTextView.setTextColor(black);
            measureTextView.setTextColor(black);
            totalTextView.setTextColor(black);
            increase.setTextColor(black);
            decrease.setTextColor(black);

        } else {
            stateView.setTextColor(gray);
            amountTextView.setTextColor(gray);
            measureTextView.setTextColor(gray);
            totalTextView.setTextColor(gray);
            increase.setTextColor(gray);
            decrease.setTextColor(gray);
        }

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentItem.decreaseAmount();
                amountTextView.setText(currentItem.getAmount());
                totalTextView.setText(currentItem.getTotal());
                Total.calcTotal(items, finalTotalTextView);
            }
        });


        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentItem.increaseAmount();
                amountTextView.setText(currentItem.getAmount());
                totalTextView.setText(currentItem.getTotal());
                Total.calcTotal(items, finalTotalTextView);
            }
        });


        stateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentItem.changeState();

                if (currentItem.getState()) {
                    stateView.setTextColor(black);
                    amountTextView.setTextColor(black);
                    measureTextView.setTextColor(black);
                    totalTextView.setTextColor(black);
                    increase.setTextColor(black);
                    decrease.setTextColor(black);
                    Total.calcTotal(items, finalTotalTextView);

                } else {
                    stateView.setTextColor(gray);
                    amountTextView.setTextColor(gray);
                    measureTextView.setTextColor(gray);
                    totalTextView.setTextColor(gray);
                    increase.setTextColor(gray);
                    decrease.setTextColor(gray);
                    Total.calcTotal(items, finalTotalTextView);
                }
            }
        });


        return listItemView;
    }


}
