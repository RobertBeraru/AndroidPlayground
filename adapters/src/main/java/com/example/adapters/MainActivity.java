package com.example.adapters;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1- AdapterView: ListView
        listView = findViewById(R.id.listView);

        //2- Data Source: String Array
        String[] countries = {"Romania", "Greece", "Bulgaria", "United Kingdom", "United States of America", "Saudi Arabia", "France"};

        //3- Adapter: acts as a bridge between the 'data source' the 'AdapterView'

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                countries);

        //4- Link ListView with the Adapter
        listView.setAdapter(adapter);
    }
}