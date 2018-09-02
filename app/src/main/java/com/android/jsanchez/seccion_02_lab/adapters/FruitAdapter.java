package com.android.jsanchez.seccion_02_lab.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.jsanchez.seccion_02_lab.R;
import com.android.jsanchez.seccion_02_lab.models.Fruit;

import java.util.List;

public class FruitAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Fruit> fruits;

    public FruitAdapter(Context context, int layout, List<Fruit> fruits) {
        this.context = context;
        this.layout = layout;
        this.fruits = fruits;
    }

    @Override
    public int getCount() {
        return fruits.size();
    }

    @Override
    public Fruit getItem(int i) {
        return fruits.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;

        if (convertView == null){

           convertView =  LayoutInflater.from(context).inflate(layout, null);

           holder = new ViewHolder();
           {
                holder.name = convertView.findViewById(R.id.textViewName);
                holder.icon = convertView.findViewById(R.id.imageViewIcon);
                holder.origin = convertView.findViewById(R.id.textViewOrigin);
           }
           convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Fruit currentFruit = getItem(position);

        holder.name.setText(currentFruit.getName());
        holder.origin.setText(currentFruit.getOrigin());
        holder.icon.setImageResource(currentFruit.getIcon());

        return convertView;
    }

    static class ViewHolder{
        private TextView name;
        private TextView origin;
        private ImageView icon;

    }
}
