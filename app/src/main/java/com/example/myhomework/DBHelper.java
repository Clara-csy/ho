package com.example.myhomework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {
    private static SQLiteDatabase sqLiteDatabase;


    //创建数据库
    public DBHelper(Context context){
        super(context, DBUtils.DATABASE_NAME,null,DBUtils.DATABASE_VERION);
        sqLiteDatabase=this.getWritableDatabase();
    }
    //创建表
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+DBUtils.DATABASE_TABLE+"("+DBUtils.NOTEPAD_ID+
                " INTEGER PRIMARY KEY AUTOINCREMENT,"+DBUtils.NOTEPAD_SHENG+" text, "+DBUtils.NOTEPAD_SHI+" text," +
                DBUtils.NOTEPAD_QU+" text,"+DBUtils.NOTEPAD_XIANGXI+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
    //添加数据
    public boolean insertData(String userSheng,String userShi,String userQu,String userXiangxi){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DBUtils.NOTEPAD_SHENG,userSheng);
        contentValues.put(DBUtils.NOTEPAD_SHI,userShi);
        contentValues.put(DBUtils.NOTEPAD_QU,userQu);
        contentValues.put(DBUtils.NOTEPAD_XIANGXI,userXiangxi);

        return sqLiteDatabase.insert(DBUtils.DATABASE_TABLE,null,contentValues)>0;

    }

    //删除数据
    public  boolean deleteData(String id){
        String sql=DBUtils.NOTEPAD_ID+"=?";
        //连接字符串，易错点!
        String[] contentValuesArray=new String[]{String.valueOf(id)};
        return sqLiteDatabase.delete(DBUtils.DATABASE_TABLE,sql,contentValuesArray)>0;
    }
    //查询数据
//    public List<costList> query(){
//        List<costList>list=new ArrayList<costList>();
//        Cursor cursor=sqLiteDatabase.query(DBUtils.DATABASE_TABLE,null,null,
//                null,null,null,DBUtils.NOTEPAD_ID+" desc");
//        if (cursor!=null){
//            while (cursor.moveToNext()){
//                costList noteInfo=new costList(this);
//                String id=String.valueOf(cursor.getInt(cursor.getColumnIndex(DBUtils.NOTEPAD_ID)));
//                String sheng=cursor.getString(cursor.getColumnIndex(DBUtils.NOTEPAD_SHENG));
//                String shi=cursor.getString(cursor.getColumnIndex(DBUtils.NOTEPAD_SHI));
//                String qu=cursor.getString(cursor.getColumnIndex(DBUtils.NOTEPAD_QU));
//                String xiangxi=cursor.getString(cursor.getColumnIndex(DBUtils.NOTEPAD_XIANGXI));
//                noteInfo.setId(id);
//                noteInfo.setSheng(sheng);
//                noteInfo.setShi(shi);
//                noteInfo.setQu(qu);
//                noteInfo.setXiangxi(xiangxi);
//                list.add(noteInfo);
//            }
//            cursor.close();
//        }
//        return list;
//    }

    public ArrayList<HashMap<String,String>> query_t1(){
        ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String, String>>();
        Cursor cursor=sqLiteDatabase.query(DBUtils.DATABASE_TABLE,null,null,
                null,null,null,DBUtils.NOTEPAD_ID+" desc");
        if (cursor!=null){
            while (cursor.moveToNext()){
                String id=String.valueOf(cursor.getInt(cursor.getColumnIndex(DBUtils.NOTEPAD_ID)));
                String sheng=cursor.getString(cursor.getColumnIndex(DBUtils.NOTEPAD_SHENG));
                String shi=cursor.getString(cursor.getColumnIndex(DBUtils.NOTEPAD_SHI));
                String qu=cursor.getString(cursor.getColumnIndex(DBUtils.NOTEPAD_QU));
                String xiangxi=cursor.getString(cursor.getColumnIndex(DBUtils.NOTEPAD_XIANGXI));
                Log.i("TAG","From DBhelper:///////"+sheng);
                HashMap<String,String> map =new HashMap<String, String>();
                map.put("loc",sheng+shi+qu+xiangxi);
                list.add(map);
            }
            cursor.close();
        }else
            Log.i("TAG","无数据");
        return list;
    }

    public ArrayList<String> query_t(){
        ArrayList<String> list=new ArrayList<String>();
        Cursor cursor=sqLiteDatabase.query(DBUtils.DATABASE_TABLE,null,null,
                null,null,null,DBUtils.NOTEPAD_ID+" desc");
        if (cursor!=null){
            while (cursor.moveToNext()){
                String id=String.valueOf(cursor.getInt(cursor.getColumnIndex(DBUtils.NOTEPAD_ID)));
                String sheng=cursor.getString(cursor.getColumnIndex(DBUtils.NOTEPAD_SHENG));
                String shi=cursor.getString(cursor.getColumnIndex(DBUtils.NOTEPAD_SHI));
                String qu=cursor.getString(cursor.getColumnIndex(DBUtils.NOTEPAD_QU));
                String xiangxi=cursor.getString(cursor.getColumnIndex(DBUtils.NOTEPAD_XIANGXI));
                Log.i("TAG","From DBhelper:///////"+sheng);
                String map =new String();
                list.add(sheng+shi+qu+xiangxi);
            }
            cursor.close();
        }else
            Log.i("TAG","无数据");
        return list;
    }
}
