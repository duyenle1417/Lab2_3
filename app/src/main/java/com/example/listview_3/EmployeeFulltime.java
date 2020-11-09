package com.example.listview_3;

import androidx.annotation.NonNull;

public class EmployeeFulltime extends Employee {
    @Override
    public double TinhLuong() {
        salary=500.0;
        return salary;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() +" --> FullTime="+ TinhLuong();
    }
}
