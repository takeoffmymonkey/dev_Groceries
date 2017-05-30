package com.example.android.groceries;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] names = {
                "Хлеб",
                "Морковь",
                "Бананы",
                "Кефир",
                "Сыр",
                "Овсянка (пор)",
                "Гречка (хл)",

                "Овсянка (хл)",
                "Мясо",
                "Печенье",

                "Зелень",
                "Огурцы",
                "Помидоры",
                "Гречка",
                "Рис",
                "Буряк",
                "Лук",
                "Картошка",
                "Вермишель",
                "Тест"};

        Double[] prices = {
                7.45,
                12.69,
                31.95,
                15.95,
                33.95,
                20.60,
                20.69,

                0.00,
                0.00,
                0.00,

                0.00,
                0.00,
                0.00,
                0.00,
                0.00,
                0.00,
                0.00,
                0.00,
                0.00,
                0.00
        };

        //Creating list of Item objects
        items = new ArrayList<Item>();

        for (int i = 0; i < names.length; i++) {
            items.add(new Item(names[i], prices[i]));
        }

        //Creating adapter, linking to the list of Item objects
        ItemAdapter itemAdapter = new ItemAdapter(this, items);

        //Creating ListView object, linking to list_view xml element
        ListView listView = (ListView) findViewById(R.id.list_view);

        //Directing adapter to list_view xml element
        listView.setAdapter(itemAdapter);


    }


}

