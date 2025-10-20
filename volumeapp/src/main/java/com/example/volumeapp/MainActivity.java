package com.example.volumeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 1 - AdapterView: GridView
    GridView gridView;

    // 2 - Data Source: ArrayList<Shape>
    ArrayList<Shape> shapeArrayList;
    private static MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        shapeArrayList = new ArrayList<>();

        Shape s1 = new Shape(R.drawable.sphere, "Sphere");
        Shape s2 = new Shape(R.drawable.cylinder, "Cylinder");
        Shape s3 = new Shape(R.drawable.prism, "Prism");
        Shape s4 = new Shape(R.drawable.cube, "Cube");

        shapeArrayList.add(s1);
        shapeArrayList.add(s2);
        shapeArrayList.add(s3);
        shapeArrayList.add(s4);

        adapter = new MyCustomAdapter(shapeArrayList, getApplicationContext());
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Shape clickedShape = shapeArrayList.get(position);
                String shapeName = clickedShape.getShapeName();
                Intent intent;

                switch (shapeName) {
                    case "Sphere":
                        intent = new Intent(MainActivity.this, Sphere.class);
                        break;
                    case "Cylinder":
                        intent = new Intent(MainActivity.this, Cylinder.class);
                        break;
//                    case "Prism":
//                        intent = new Intent(MainActivity.this, Prism.class);
//                        break;
//                    case "Cube":
//                        intent = new Intent(MainActivity.this, Cube.class);
//                        break;
                    default:
                        return; // no action for unknown shape name
                }
                startActivity(intent);
            }
        });
    }
}