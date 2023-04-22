package com.example.nhanvien2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;


import com.example.nhanvien2.database.SQLiteHelper;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{
    public Spinner sp;
    private EditText ete,enoidung;
    private RadioButton radioButton1,radioButton2;
    private CheckBox checkBox1,checkBox2,checkBox3;
    private Button btUpdate,btCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        btUpdate.setOnClickListener(this);
        btCancel.setOnClickListener(this);
//        engayht.setOnClickListener(this);
    }

    private void initView() {
        sp=findViewById(R.id.spCategory);
        ete=findViewById(R.id.tvte);
        enoidung=findViewById(R.id.tvnoidung);
//        engayht=findViewById(R.id.tvngayht);
        radioButton1=findViewById(R.id.radio_motminh);
        radioButton2=findViewById(R.id.radio_lamchung);
        checkBox1 = findViewById(R.id.android_checkbox);
        checkBox2 = findViewById(R.id.web_checkbox);
        checkBox3 = findViewById(R.id.ios_checkbox);
        btUpdate=findViewById(R.id.btUpdate);
        btCancel=findViewById(R.id.btCancel);
        sp.setAdapter(new ArrayAdapter<String>(this,R.layout.itemspinner,getResources().getStringArray(R.array.category)));

    }

    @Override
    public void onClick(View view) {
//        if(view==engayht){
//            final Calendar c=Calendar.getInstance();
//            int year=c.get(Calendar.YEAR);
//            int month=c.get(Calendar.MONTH);
//            int day=c.get(Calendar.DAY_OF_MONTH);
//            DatePickerDialog dialog=new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
//                @Override
//                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
//                    String date="";
//                    if(m>8){
//                        date=d+"/"+(m+1)+"/"+y;
//                    }
//                    else{
//                        date=d+"/0"+(m+1)+"/"+y;
//                    }
//                    engayht.setText(date);
//                }
//            },year,month,day);
//            dialog.show();
//        }
        if(view==btCancel){
            finish();
        }
        if(view==btUpdate){
            String t = ete.getText().toString();
            String p= enoidung.getText().toString();
            String c=sp.getSelectedItem().toString();
//            String d=engayht.getText().toString();
            String ct ="";
            if(radioButton1.isChecked()){
                ct+= radioButton1.getText().toString();
            }
            if(radioButton2.isChecked()){
                ct+= radioButton2.getText().toString();
            }
            String kn = "";
            if(checkBox1.isChecked()){
                kn+= checkBox1.getText().toString();
            }
            if(checkBox2.isChecked()){
                kn+= checkBox2.getText().toString();
            }
            if(checkBox3.isChecked()){
                kn+= checkBox3.getText().toString();
            }
            if(!t.isEmpty() && !p.isEmpty()){
                Item i= new Item(t,p,kn,c,ct);
                SQLiteHelper db= new SQLiteHelper(this);
                db.addItem(i);
                finish();
            }
        }
    }
}