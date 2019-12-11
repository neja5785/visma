package com.visma;

import java.util.Date;

public class Goods implements Comparable<Goods> {

    private String itemName;
    private Long code;
    private int quantity;
    private Date expDate;


    Goods(String itemName, Long code, int quantity, Date expDate) {
        this.itemName = itemName;
        this.code = code;
        this.quantity = quantity;
        this.expDate = expDate;
    }
    @Override
    public int compareTo(Goods o) {
        return this.itemName.compareTo(o.itemName); // dog name sort in ascending order
        //return o.getName().compareTo(this.name); use this line for dog name sort in descending order
    }

    public String getItemName() {
        return itemName;
    }

    public Long getCode() {
        return code;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getExpDate() {
        return expDate;
    }
}

