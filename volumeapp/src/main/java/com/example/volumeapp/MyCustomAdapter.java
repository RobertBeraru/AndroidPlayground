package com.example.volumeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapesArrayList;
    Context context;

    public MyCustomAdapter( ArrayList<Shape> shapesArrayList, Context context) {
        super(context, R.layout.grid_item_layout,shapesArrayList);
        this.shapesArrayList = shapesArrayList;
        this.context = context;
    }

    //View Holder:
    private static class MyViewHolder {
        TextView shapeName;
        ImageView shapeImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Shape shapes = getItem(position);
        MyViewHolder myViewHolder;
        final View result;

        if(convertView == null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.grid_item_layout, parent,false);

            myViewHolder.shapeName = (TextView) convertView.findViewById(R.id.textView);
            myViewHolder.shapeImage = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;

            convertView.setTag(myViewHolder);

        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        myViewHolder.shapeName.setText(shapes.getShapeName());
        myViewHolder.shapeImage.setImageResource(shapes.getShapeImage());

        return result;
    }
}
