package com.example.myhomework;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    Button confirm;
    Button xiugai;

    private DBHelper helper;
    private ListView listView;
    private ImageButton Add;
    private List<costList> list;

    private DBHelper mDBHelper;
    private String id;
    private TextView diqu;
    private TextView diqu2;
    private TextView diqu3;
    private TextView xiangxi;
    String TAG ="111";

    ListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_third );

        initData();

        Button button=findViewById(R.id.confirm);
        diqu=(TextView)findViewById(R.id.text_diqu);
        diqu2=(TextView)findViewById(R.id.text_diqu2);
        diqu3=(TextView)findViewById(R.id.text_diqu3);
        xiangxi=(TextView)findViewById(R.id.allAddress);


        //confirm的跳转，fourth
        confirm=(Button)findViewById(R.id.confirm);
        confirm.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(ThirdActivity.this);
                db.insertData(diqu.getText().toString(),diqu2.getText().toString(),diqu3.getText().toString(),xiangxi.getText().toString());
                Log.i(TAG,diqu.getText().toString());
                Intent intent=new Intent();
                intent.setClass(ThirdActivity.this,FourthActivity.class);
                startActivity(intent);

                switch (v.getId()){
                    case R.id.btn_look2:
                        String noteDiqu =diqu.getText().toString().trim();
                        String noteDiqu2 =diqu.getText().toString().trim();
                        String noteDiqu3 =diqu.getText().toString().trim();
                        String noteAllAddress =diqu.getText().toString().trim();


                        finish();
                        break;}



            }
        } );
        //xiugai的跳转，main
        xiugai=(Button)findViewById(R.id.xiugai);
        xiugai.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ThirdActivity.this,MainActivity.class);
                startActivity(intent);
            }
        } );

        //获取省市区，具体地址的数据
        Intent intent=getIntent();
        TextView allAddress=findViewById(R.id.allAddress);
        allAddress.setText(intent.getStringExtra("data"));

        TextView text_diqu=findViewById(R.id.text_diqu);
        text_diqu.setText(intent.getStringExtra("data2"));

        TextView text_diqu2=findViewById(R.id.text_diqu2);
        text_diqu2.setText(intent.getStringExtra("data3"));

        TextView text_diqu3=findViewById(R.id.text_diqu3);
        text_diqu3.setText(intent.getStringExtra("data4"));


    }

    private void initData() {
        mDBHelper=new DBHelper(this);

        Intent intent=getIntent();
        if(intent!=null) {
            id = intent.getStringExtra( "id" );
        }



    }
    public void showToast(String message){
        Toast.makeText(ThirdActivity.this,message,Toast.LENGTH_LONG).show();
    }
    }



