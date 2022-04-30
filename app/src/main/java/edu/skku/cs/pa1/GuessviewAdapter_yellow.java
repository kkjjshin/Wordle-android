package edu.skku.cs.pa1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GuessviewAdapter_yellow extends BaseAdapter {

    private Context mContext_yellow;
    private ArrayList<Guesscontents_yellow> items_yellow;

    public GuessviewAdapter_yellow(Context mContext_yellow, ArrayList<Guesscontents_yellow> items_yellow){
        this.mContext_yellow = mContext_yellow;
        this.items_yellow = items_yellow;
    }

    @Override
    public int getCount() {
        return items_yellow.size();
    }

    @Override
    public Object getItem(int i) {
        return items_yellow.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext_yellow.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.guessview_gray, viewGroup, false); //질문
        }

        TextView text_yellow = view.findViewById(R.id.tv_gray);
        text_yellow.setText(items_yellow.get(i).alphabet_yellow);
        text_yellow.setBackgroundColor(Color.parseColor( "#FFFFE46F"));
        text_yellow.setTextColor(Color.parseColor("#FF000000"));
        return view;
    }
}
