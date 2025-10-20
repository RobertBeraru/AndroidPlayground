package com.example.volumeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cube extends AppCompatActivity {

    EditText cube_width;
    TextView title, result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cube);

        cube_width = findViewById(R.id.editText_Cube);
        title = findViewById(R.id.cubeText);
        result = findViewById(R.id.resultText);
        btn = findViewById(R.id.cubeBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String width = cube_width.getText().toString();
                int w = Integer.parseInt(width);

                double volume = w * w * w;
                result.setText("V = " + volume + " m^3");
            }
        });

    }
}