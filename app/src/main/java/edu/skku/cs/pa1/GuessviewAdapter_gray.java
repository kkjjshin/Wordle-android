package edu.skku.cs.pa1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GuessviewAdapter_gray extends BaseAdapter {

    private Context mContext_gray;
    private ArrayList<Guesscontents_gray> items_gray;

    public GuessviewAdapter_gray(Context mContext_gray, ArrayList<Guesscontents_gray> items_gray){
        this.mContext_gray = mContext_gray;
        this.items_gray = items_gray;

    }

    @Override
    public int getCount() {
        return items_gray.size();
    }

    @Override
    public Object getItem(int i) {
        return items_gray.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext_gray.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.guessview_gray, viewGroup, false); //질문
        }

        TextView text_gray = view.findViewById(R.id.tv_gray);
        text_gray.setText(items_gray.get(i).alphabet_gray);
        text_gray.setBackgroundColor(Color.parseColor( "#FF787C7E"));
        text_gray.setTextColor(Color.parseColor("#FFFFFFFF"));

        return view;
    }
}
