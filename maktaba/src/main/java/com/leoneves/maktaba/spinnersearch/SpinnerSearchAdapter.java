package com.leoneves.maktaba.spinnersearch;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import com.leoneves.maktaba.R;

/**
 * Created by leo on 07/12/16.
 */

public class SpinnerSearchAdapter extends BaseAdapter {
    private Context context;
    private List<Object> objects;
    private List<String> names;
    private Object selected;
    private SpinnerSearchListener searchListener;
    private String noOneFound;
    private String selectOne;

    public SpinnerSearchAdapter(Context context, String word, SpinnerSearchListener searchListener, String noOneFound, String selectOne) {
        this.context = context;
        this.searchListener = searchListener;
        this.selectOne = selectOne;
        this.noOneFound = noOneFound;
        objects = searchListener.getObjetcs(word);
        names = searchListener.getNames(word);
    }

    @Override
    public int getCount() {
        return objects.size()+1;
    }

    @Override
    public Object getItem(int position) {
        selected = position==0?null: objects.get(position-1);
        return selected ==null ? "" : names.get(position-1);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public Object getSelected() {
        return objects.isEmpty() ? null : selected;
    }

    public int getSelectedPosition(Object selected){
        int position = -1;
        for (int i = 0; i< objects.size(); i++)
            if (objects.get(i).equals(selected))
                position = i;
        return ++position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
        }
        ((TextView) view).setText(null);
        return view;
    }

    @Override
    public View getDropDownView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.spinnersearch_textadapter, parent, false);
        }
        TextView txtTitle = (TextView) view;
        if (position > 0) {
            String name = names.get(position-1);
            txtTitle.setText(name);
            txtTitle.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
            txtTitle.setTextColor(Color.parseColor("#282828"));
        } else {
            txtTitle.setText(objects.isEmpty() ? noOneFound : selectOne);
            txtTitle.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
            txtTitle.setTextColor(context.getResources().getColor(android.R.color.darker_gray));
        }
        return view;
    }

}
