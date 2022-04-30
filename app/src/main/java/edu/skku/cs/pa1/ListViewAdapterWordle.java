package edu.skku.cs.pa1;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapterWordle extends BaseAdapter {

    private Context mContext;
    private ArrayList<InputWordle> items;

    public ListViewAdapterWordle(Context mContext, ArrayList<InputWordle> items) {
        this.mContext = mContext;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.create_wordle, viewGroup, false); //질문

        }

        TextView text1 = view.findViewById(R.id.tv1);
        TextView text2 = view.findViewById(R.id.tv2);
        TextView text3 = view.findViewById(R.id.tv3);
        TextView text4 = view.findViewById(R.id.tv4);
        TextView text5 = view.findViewById(R.id.tv5);

        //알파벳 각각 리스트 뷰에 넣어줌
        text1.setText(items.get(i).alphabet1);
        text2.setText(items.get(i).alphabet2);
        text3.setText(items.get(i).alphabet3);
        text4.setText(items.get(i).alphabet4);
        text5.setText(items.get(i).alphabet5);

        //각각 textview 배경컬러 및 텍스트 색 바꿔줌

        //tv1
        if (items.get(i).tvColor1.equals("Green")) {
            text1.setBackgroundColor(Color.parseColor("#FF99F691"));
            text1.setTextColor(Color.parseColor("#FF000000"));
        } else if (items.get(i).tvColor1.equals("Yellow")) {
            text1.setBackgroundColor(Color.parseColor("#FFFFE46F"));
            text1.setTextColor(Color.parseColor("#FF000000"));

        } else if (items.get(i).tvColor1.equals("Gray")) {
            text1.setBackgroundColor(Color.parseColor("#FF787C7E"));
            text1.setTextColor(Color.parseColor("#FFFFFFFF"));
        }
        //tv2
        if (items.get(i).tvColor2.equals("Green")) {
            text2.setBackgroundColor(Color.parseColor("#FF99F691"));
            text2.setTextColor(Color.parseColor("#FF000000"));
        } else if (items.get(i).tvColor2.equals("Yellow")) {
            text2.setBackgroundColor(Color.parseColor("#FFFFE46F"));
            text2.setTextColor(Color.parseColor("#FF000000"));
        } else if (items.get(i).tvColor2.equals("Gray")) {
            text2.setBackgroundColor(Color.parseColor("#FF787C7E"));
            text2.setTextColor(Color.parseColor("#FFFFFFFF"));
        }
        //tv3
        if (items.get(i).tvColor3.equals("Green")) {
            text3.setBackgroundColor(Color.parseColor("#FF99F691"));
            text3.setTextColor(Color.parseColor("#FF000000"));
        } else if (items.get(i).tvColor3.equals("Yellow")) {
            text3.setBackgroundColor(Color.parseColor("#FFFFE46F"));
            text3.setTextColor(Color.parseColor("#FF000000"));
        } else if (items.get(i).tvColor3.equals("Gray")) {
            text3.setBackgroundColor(Color.parseColor("#FF787C7E"));
            text3.setTextColor(Color.parseColor("#FFFFFFFF"));
        }
        //tv4
        if (items.get(i).tvColor4.equals("Green")) {
            text4.setBackgroundColor(Color.parseColor("#FF99F691"));
            text4.setTextColor(Color.parseColor("#FF000000"));
        } else if (items.get(i).tvColor4.equals("Yellow")) {
            text4.setBackgroundColor(Color.parseColor("#FFFFE46F"));
            text4.setTextColor(Color.parseColor("#FF000000"));
        } else if (items.get(i).tvColor4.equals("Gray")) {
            text4.setBackgroundColor(Color.parseColor("#FF787C7E"));
            text4.setTextColor(Color.parseColor("#FFFFFFFF"));
        }
        //tv5
        if (items.get(i).tvColor5.equals("Green")) {
            text5.setBackgroundColor(Color.parseColor("#FF99F691"));
            text5.setTextColor(Color.parseColor("#FF000000"));
        } else if (items.get(i).tvColor5.equals("Yellow")) {
            text5.setBackgroundColor(Color.parseColor("#FFFFE46F"));
            text5.setTextColor(Color.parseColor("#FF000000"));
        } else if (items.get(i).tvColor5.equals("Gray")) {
            text5.setBackgroundColor(Color.parseColor("#FF787C7E"));
            text5.setTextColor(Color.parseColor("#FFFFFFFF"));
        }


        Log.d("alphawordcheck", items.get(i).tvColor1);
        Log.d("alphawordcheck2", items.get(i).tvColor2);
        Log.d("alphawordcheck3", items.get(i).tvColor3);
        Log.d("alphawordcheck4", items.get(i).tvColor4);
        Log.d("alphawordcheck5", items.get(i).tvColor5);




        return view;
    }
}
