package com.example.listview_3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editTextId;
    EditText editTextName;
    RadioGroup radioGroup;
    ListView listView;
    ArrayList<Employee> employees;
    ArrayAdapter<Employee> adapter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_nhap);
        editTextId = findViewById(R.id.edit_text_manv);
        editTextName = findViewById(R.id.edit_text_ten);
        radioGroup = findViewById(R.id.radio_group_loai_nv);
        listView = findViewById(R.id.list_view);
        textView= findViewById(R.id.text_view_status);
        employees= new ArrayList<Employee>();

        adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employees);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextId.length()>0 && editTextName.length()>0
                    && radioGroup.getCheckedRadioButtonId()!=-1) {
                    addNewEmployee();
                    editTextId.setText("");
                    editTextName.setText("");
                    radioGroup.clearCheck();
                }
                else
                    Toast.makeText(MainActivity.this,"Mời nhập đầy đủ thông tin!",Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Delete: "+employees.get(position).toString(),Toast.LENGTH_SHORT ).show();
                employees.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText("position :" + position + " ; value =" + employees.get(position));
            }
        });
    }

    public void addNewEmployee() {
        //Lấy ra đúng id của Radio Button được checked
        int radId = radioGroup.getCheckedRadioButtonId();
        String id = editTextId.getText().toString();
        String name = editTextName.getText().toString();
        Employee employee;
        if (radId == R.id.rb_chinh_thuc) {
            //tạo instance là FullTime
            employee = new EmployeeFulltime();
        } else {
            //Tạo instance là Parttime
            employee = new EmployeeParttime();
        }
        //FullTime hay Parttime thì cũng là Employee nên có các hàm này là hiển nhiên
        employee.setId(id);
        employee.setName(name);
        //Đưa employee vào ArrayList
        employees.add(employee);
        adapter.notifyDataSetChanged();
        //kiểm tra
        Toast.makeText(MainActivity.this,"Thêm dữ liệu thành công!", Toast.LENGTH_SHORT).show();
    }
}