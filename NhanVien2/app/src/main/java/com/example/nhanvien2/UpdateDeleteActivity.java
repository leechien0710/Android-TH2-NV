package com.example.nhanvien2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

public class UpdateDeleteActivity extends AppCompatActivity implements View.OnClickListener {
    public Spinner sp;
    private EditText ete,enoidung;
    private RadioButton radioButton1,radioButton2;
    private Button btUpdate,btBack,btRemove;
    private CheckBox checkBox1,checkBox2,checkBox3;


    private Item item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);
        initView();
        btUpdate.setOnClickListener(this);
        btBack.setOnClickListener(this);
        btRemove.setOnClickListener(this);
//        engayht.setOnClickListener(this);
        Intent intent=getIntent();
        item= (Item) intent.getSerializableExtra("item");
        ete.setText(item.getTen());
        enoidung.setText(item.getNoidung());
//        engayht.setText(item.getNgayht());
        int p=0;
        for(int i=0;i<sp.getCount();i++){
            if(sp.getItemAtPosition(i).toString().equalsIgnoreCase(item.getTt())){
                p=i;
                break;
            }
        }
        sp.setSelection(p);
    }

    private void initView() {
        sp=findViewById(R.id.spCategory);
        ete=findViewById(R.id.tvte);
        enoidung=findViewById(R.id.tvnoidung);
//        engayht=findViewById(R.id.tvngayht);
        checkBox1 = findViewById(R.id.android_checkbox);
        checkBox2 = findViewById(R.id.web_checkbox);
        checkBox3 = findViewById(R.id.ios_checkbox);
        radioButton1 = findViewById(R.id.radio_motminh);
        radioButton1.setChecked(true);
        radioButton2 = findViewById(R.id.radio_lamchung);

        btUpdate=findViewById(R.id.btUpdate);
        btBack=findViewById(R.id.btBack);
        btRemove=findViewById(R.id.btRemove);
        sp.setAdapter(new ArrayAdapter<String>(this,R.layout.itemspinner,getResources().getStringArray(R.array.category)));
    }

    @Override
    public void onClick(View view) {
        SQLiteHelper db= new SQLiteHelper(this);
//        if(view==engayht){
//            final Calendar c=Calendar.getInstance();
//            int year=c.get(Calendar.YEAR);
//            int month=c.get(Calendar.MONTH);
//            int day=c.get(Calendar.DAY_OF_MONTH);
//            DatePickerDialog dialog=new DatePickerDialog(UpdateDeleteActivity.this, new DatePickerDialog.OnDateSetListener() {
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
        if(view==btBack){
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
                int id = item.getId();
                Item i= new Item(id,t,p,kn,c,ct);
                db.updateItem(i);
                finish();
            }
        }
        if(view==btRemove){
            int id=item.getId();
            AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
            builder.setTitle("Thong bao xoa!");
            builder.setTitle("Ban co chac muon xoa "+item.getTen()+" khong?");
            builder.setIcon(R.drawable.baseline_remove_circle_24);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    db.deleteItem(id);
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog=builder.create();
            dialog.show();
        }
    }
}