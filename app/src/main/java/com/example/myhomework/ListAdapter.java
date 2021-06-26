package com.example.myhomework;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class ListAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;//这个对象用于加载item的布局文件
    private List<costList>costList;//list集合是列表中需要显示的集合
    public ListAdapter(Context context, List<costList>costList){
        layoutInflater=LayoutInflater.from(context);
        this.costList= costList;
    }
    //源代码
    @Override
    public int getCount() {
        return costList==null?0:costList.size();
    }//获取集合长度

    @Override
    public Object getItem(int position) {
        return costList.get(position);
    }//返回集合的内容

    @Override
    public long getItemId(int position) {
        return position;
    }//返回位置信息

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.address_item,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }

        costList costlist=(costList) getItem(position);

        viewHolder.tvSheng.setText(costlist.getSheng());
        viewHolder.tvShi.setText(costlist.getShi());
        viewHolder.tvQu.setText(costlist.getQu());
        viewHolder.tvXiangxi.setText(costlist.getXiangxi());


        return convertView;
    }
    class ViewHolder{
        TextView tvSheng;
        TextView tvShi;
        TextView tvQu;
        TextView tvXiangxi;

        //获得地址数据
        public ViewHolder(View view){
            tvSheng=view.findViewById(R.id.item_sheng);
            tvShi=view.findViewById(R.id.item_shi);
            tvQu=view.findViewById(R.id.item_qu);
            tvShi=view.findViewById(R.id.item_xiangxi);

        }
    }
}

