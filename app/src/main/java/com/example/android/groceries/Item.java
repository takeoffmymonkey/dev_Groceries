package com.example.android.groceries;

import java.text.DecimalFormat;
import java.util.Currency;

/**
 * Created by takeoff on 005 05 May 17.
 */

public class Item {

    //Global vars
    private String name; // Item's name
    private int amount; // Item's amount
    private String measure = "кг"; // Item's unit of measure
    private double price; // Item's price
    private boolean isActive = false; // Item's status
    private double totalPrice; // Item's total price


    Item() {

    }

    /**
     * Constructor
     *
     * @param name  - Item's name
     * @param price - Item's price
     */
    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    String getAmount() {
        return ("" + amount);
    }

    String getMeasure() {
        return measure;
    }

    boolean getState() {
        return isActive;
    }

    void changeState() {
        isActive = !isActive;
    }

    void increaseAmount() {
        amount++;
    }

    void decreaseAmount() {
        if (amount > 0) amount--;
    }

    String getTotal() {
        totalPrice = price * amount;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return ("" + decimalFormat.format(totalPrice) + "UAH");
    }

    double getTotal(int i) {
        return totalPrice = price * amount;
    }

}
