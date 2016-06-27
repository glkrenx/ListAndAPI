package com.glkrenx.bermainlistdanapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.glkrenx.bermainlistdanapi.R;

import java.util.ArrayList;

/**
 * Created by glkrenx on 24/06/16.
 */
public class DataAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<String> namaTaksi;

    public DataAdapter(Context mContext, ArrayList<String> namaTaksi) {
        this.mContext = mContext;
        this.namaTaksi = namaTaksi;
    }

    @Override
    public int getCount() {
        return namaTaksi.size();
    }

    @Override
    public Object getItem(int position) {
        return namaTaksi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        /*Required to inflate list to view, if u dont.. app goes drunk*/
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder = null;

        if (view == null){
            view = inflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder)view.getTag();
        }

        holder.txtTaksi.setText(namaTaksi.get(position));

        return view;
    }

    /*ViewHolder used to hold view objects*/
    static class ViewHolder{
        TextView txtTaksi;

        public ViewHolder() {
        }

        public ViewHolder(View view) {
            txtTaksi = (TextView)view.findViewById(R.id.txtTaksi);
        }
    }
}
