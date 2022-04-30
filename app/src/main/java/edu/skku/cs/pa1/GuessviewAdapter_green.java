package edu.skku.cs.pa1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GuessviewAdapter_green extends BaseAdapter {

    private Context mContext_green;
    private ArrayList<Guesscontents_green> items_green;

    public GuessviewAdapter_green(Context mContext_green, ArrayList<Guesscontents_green> items_green){
        this.mContext_green = mContext_green;
        this.items_green = items_green;
    }

    @Override
    public int getCount() {
        return items_green.size();
    }

    @Override
    public Object getItem(int i) {
        return items_green.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext_green.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.guessview_gray, viewGroup, false); //질문
        }

        TextView text_gray = view.findViewById(R.id.tv_gray);
        text_gray.setText(items_green.get(i).alphabet_green);
        text_gray.setBackgroundColor(Color.parseColor( "#FF99F691"));
        text_gray.setTextColor(Color.parseColor("#FF000000"));
        return view;
    }
}
