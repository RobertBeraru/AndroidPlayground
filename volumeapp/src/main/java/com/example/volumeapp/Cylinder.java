package com.example.volumeapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Cylinder extends AppCompatActivity {
    TextView title, result;
    EditText cylinder_radius,cylinder_height;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);
        cylinder_radius = findViewById(R.id.editText_Cylinder1);
        cylinder_height = findViewById(R.id.editText_Cylinder2);
        title = findViewById(R.id.cylinderText);
        result = findViewById(R.id.resultText);
        button = findViewById(R.id.cylinderBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = cylinder_radius.getText().toString().trim();
                String height = cylinder_height.getText().toString().trim();

                if (radius.isEmpty() || height.isEmpty()) {
                    Log.w("CylinderDebug", "Lipsesc una sau ambele valori!");
                    result.setText("Please insert both values!");
                    return;
                }
                try {
                    double r = Double.parseDouble(radius);
                    double h = Double.parseDouble(height);
                    double V = Math.PI * r * r * h;
                    Log.i("CylinderDebug", "Volum calculat: " + V);
                    result.setText("V = " + V + " cm^3");
                } catch (NumberFormatException e) {
                    Log.e("CylinderDebug", "Valori invalide: " + e.getMessage());
                    result.setText("Please insert only numbers!");
                }
            }
        });

    }
}
