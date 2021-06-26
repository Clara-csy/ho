package com.example.myhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddressListActivity<retList> extends ListActivity {
    private static final String TAG =null;
   // String data[]={"四川成都温江区柳台大道555号","贵州贵阳花溪区甲秀南路西","北京东城区东华门街道22号"};
    Handler handler;
    public ArrayList<String> list_item;
    public ListView list ;
    public List<costList> costList;
    public DBHelper db;

    ListAdapter adapter2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        //setContentView(R.layout.activity_address_list);

        //list = findViewById( R.id.list );
         db =new DBHelper( AddressListActivity.this );
        list_item = db.query_t();

//        SimpleAdapter adapter = new SimpleAdapter( AddressListActivity.this, list_item, R.layout.activity_address_list, new String[]{"loc"}, new int[]{R.id.list} );
          ArrayAdapter adapter = new ArrayAdapter( AddressListActivity.this, android.R.layout.simple_list_item_1, list_item);
//        list.setAdapter( adapter );
           setListAdapter( adapter );

        list=getListView();
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog dialog;
                AlertDialog.Builder builder=new AlertDialog.Builder(AddressListActivity.this)
                        .setMessage("是否删除此记录?")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                costList costlist = costList.get(position);
                                if(db.deleteData(costlist.getId())){
                                    costList.remove(position);
                                    adapter2.notifyDataSetChanged();
                                    Toast.makeText(AddressListActivity.this,"删除成功",Toast.LENGTH_LONG).show();
                                }

                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                dialog=builder.create();
                dialog.show();
                return true;
            }
        });

    }

}