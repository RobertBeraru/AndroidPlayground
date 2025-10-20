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

public class Sphere extends AppCompatActivity {
    EditText sphere_radius;
    TextView title, result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);
        sphere_radius = findViewById(R.id.editText_Sphere);
        title = findViewById(R.id.sphereText);
        result = findViewById(R.id.resultText);
        btn = findViewById(R.id.sphereBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = sphere_radius.getText().toString();
                int r = Integer.parseInt(radius);

                double volume = (4/3) * 3.14159 * r * r * r;
                result.setText("V = " + volume + " m^3");
            }
        });

    }
}