package com.example.th2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ListView List_Person;
    TextView tv;
    ArrayList<String> arrayName;
    Button btnAdd;
    EditText edtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv_person);
        List_Person = (ListView) findViewById(R.id.lv_person);
        edtName = (EditText) findViewById(R.id.edtName);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        arrayName = new ArrayList<>();
        arrayName.add("Tèo");
        arrayName.add("Tý");
        arrayName.add("Bin");
        arrayName.add("Bo");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayName);
        List_Person.setAdapter(adapter);
        //Lấy tên từ EditText và thêm vào danh sách. Sau đó, cập nhật adapter để ListView hiển thị danh sách mới.
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtName.getText().toString();
                arrayName.add(ten);
                adapter.notifyDataSetChanged();
            }
        });
        //Xử lý sự kiện khi người dùng click vào một phần tử trong ListView:
        // ++Hiển thị vị trí và giá trị của phần tử được chọn trong TextView.
        List_Person.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {
//                        Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                String value = List_Person.getItemAtPosition(position).toString();
                tv.setText("position :" + position+ " ; value =" + value);
            }
        });
        //Xử lý sự kiện khi người dùng long click vào một phần tử trong ListView:
        // ++Xóa phần tử khỏi danh sách và cập nhật adapter để ListView hiển thị danh sách mới.
        List_Person.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                arrayName.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}