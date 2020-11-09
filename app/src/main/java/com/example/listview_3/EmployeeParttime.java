package com.example.listview_3;

import androidx.annotation.NonNull;

public class EmployeeParttime extends Employee {
    @Override
    public double TinhLuong() {
        salary=150.0;
        return salary;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() +" --> PartTime="+ TinhLuong();
    }
}
