package com.example.th3;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etId;
    EditText etName;
    RadioGroup rgType;
    Button btnNhap;
    ListView lvNV;
    ArrayList<Employee> employees;
    ArrayAdapter<Employee> adapter;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        rgType = findViewById(R.id.rgType);
        btnNhap = findViewById(R.id.btnNhap);
        lvNV = findViewById(R.id.lv_NV);

        employees = new ArrayList<>();
        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, employees);
        lvNV.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewEmployee();
            }
        });
    }

    public void addNewEmployee() {
        int radId = rgType.getCheckedRadioButtonId();
        String id = etId.getText().toString();
        String name = etName.getText().toString();
        if (radId == R.id.rd_ct) {
            //tạo instance là FullTime
            employee = new EmployeeFullTime();
        } else {
            //Tạo instance là Partime
            employee = new EmployeePartTime();
        }
        //FullTime hay Partime thì cũng là Employee nên có các hàm này là hiển nhiên
        employee.setId(id);
        employee.setName(name);
        //Đưa employee vào ArrayList
        employees.add(employee);
        //Cập nhập giao diện
        adapter.notifyDataSetChanged();
    }
}