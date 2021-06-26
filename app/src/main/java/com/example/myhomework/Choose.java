package com.example.myhomework;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Choose {
    public String name;
    public String[] area;
    public JSONObject jsonObject;

    //构造方法，通过String把你的json对象拿到

    public void  Get_str(String str) throws JSONException {
        jsonObject = new JSONObject(str);
    }
    public void  Get_json(JSONObject jsonObject){
        this.jsonObject = jsonObject;
    }
    //拿出城市名字
    public String Get_name() throws JSONException {
        String city = jsonObject.getString("city");
        city = city.substring(1, city.length() - 1);
        JSONObject jsonObject1 = new JSONObject(city);
        name =  jsonObject1.getString("name");
        return name;
    }
    //拿出你的String[]数组
    public String[] Get_area() throws JSONException {
        String city = jsonObject.getString("city");
        city = city.substring(1, city.length() - 1);
        JSONObject jsonObject1 = new JSONObject(city);
        JSONArray area_a =jsonObject1.getJSONArray("area");
        area = new String[area_a.length()];
        for(int i=0;i<area_a.length();i++){
            area[i] = area_a.getString(i);
        }
        return area;
    }
}
