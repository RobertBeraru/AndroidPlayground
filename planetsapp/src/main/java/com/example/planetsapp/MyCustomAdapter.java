package com.example.planetsapp;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    //Using Custom Layouts --> MyCustomAdapter
    //Using Custom Objects --> extends ArrayAdapter<Planet>

    private ArrayList<Planet> planetArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Planet> planetArrayList, Context context1) {
        super(context1, R.layout.my_list_item, planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context1;
    }

    // View Holder Class: used to cache references to the views within an item layout,
    // so that they don't need to be repeatedly looked up during scrolling

    private static class MyViewHolder{
        TextView planetName, moonCount;
        ImageView planetImg;
    }

    // getView(): used to create and return a view for a specific item in the list

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // 1- Get the planet object for the current position
        Planet planets = getItem(position);

        // 2- Inflate Layout:
        MyViewHolder myViewHolder;
        final View result;

        if (convertView == null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.my_list_item, parent, false);

            // Finding Views:

            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.textView3);
            myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.textMoon);
            myViewHolder.planetImg = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;

        convertView.setTag(myViewHolder);
        }else{
            // the view is recycled
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        myViewHolder.planetName.setText(planets.getPlanetName());
        myViewHolder.moonCount.setText(planets.getMoonCount());
        myViewHolder.planetImg.setImageResource(planets.getPlanetImage());

        return result;

    }
}
