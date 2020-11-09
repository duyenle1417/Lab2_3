package com.example.listview_3;

import androidx.annotation.NonNull;

public abstract class Employee {
    protected String id;
    protected String name;
    protected double salary;

    public void setId(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }

    public abstract double TinhLuong();

    @NonNull
    @Override
    public String toString() {
        return this.id +" - "+ this.name;
    }
}
