package com.example.myhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn2;


    Spinner spinner_sheng;
    Spinner spinner_shi;
    Spinner spinner_qu;

    private int provinceNumber;


    EditText et_detailAddress;
    private MainActivity view;

    TextView text_diqu;
    TextView text_diqu2;
    TextView text_diqu3;

    String str;
    String str2;
    String str3;

    //全局的jsonObject
    private JSONObject jsonObject;//把全国的省市区的信息以json的格式保存，解析完成后赋值为null
    private String[] allProv;//所有的省

    private ArrayAdapter<String> provinceAdapter;//省份数据适配器
    private ArrayAdapter<String> cityAdapter;//城市数据适配器
    private ArrayAdapter<String> areaAdapter;//区县数据适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        getId();

        //添加spinner的监听器
        spinner_sheng = (Spinner) findViewById( R.id.spinner_sheng );
        spinner_shi = (Spinner) findViewById( R.id.spinner_shi );
        spinner_qu = (Spinner) findViewById( R.id.spinner_qu );


        text_diqu = (TextView) findViewById( R.id.text_diqu );
        text_diqu2 = (TextView) findViewById( R.id.text_diqu2 );
        text_diqu3 = (TextView) findViewById( R.id.text_diqu3 );


        str = (String) spinner_sheng.getSelectedItem();
        str2 = (String) spinner_shi.getSelectedItem();
        str3 = (String) spinner_qu.getSelectedItem();


        //省
        spinner_sheng.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //拿到spinner里面的值
                str = spinner_sheng.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        //市
        spinner_shi.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //拿到spinner里面的值
                str2 = spinner_shi.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        //区
        spinner_qu.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //拿到spinner里面的值
                str3 = spinner_qu.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );
    }


    //获取详细地址
    public void getId() {
        et_detailAddress = findViewById( R.id.et_detailAddress );
        Button btn2 = findViewById( R.id.btn2 );

        btn2.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn2:
                Intent intent = new Intent( MainActivity.this, ThirdActivity.class );
                String address = et_detailAddress.getText().toString().trim();

                intent.putExtra( "data", address );

                intent.putExtra( "data2", str );
                intent.putExtra( "data3", str2 );
                intent.putExtra( "data4", str3 );

                startActivity( intent );

        }


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    //获取json数据
    public static void getJson(String filename, Context context) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            String fileName = null;
            BufferedReader bf = new BufferedReader( new InputStreamReader(
                    assetManager.open( fileName ) ) );
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append( line );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}






