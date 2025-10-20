package com.example.volumeapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Prism extends AppCompatActivity {
    TextView title, result;
    EditText prism_length,prism_height,prism_width;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prism);
        prism_length = findViewById(R.id.editText_Prism1);
        prism_height = findViewById(R.id.editText_Prism2);
        prism_width = findViewById(R.id.editText_Prism3);
        title = findViewById(R.id.prismText);
        result = findViewById(R.id.resultText);
        button = findViewById(R.id.prismBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length = prism_length.getText().toString().trim();
                String height = prism_height.getText().toString().trim();
                String width = prism_width.getText().toString().trim();

                if (length.isEmpty() || height.isEmpty() || width.isEmpty()) {
                    Log.w("CylinderDebug", "Lipsesc una sau mai multe valori!");
                    result.setText("Please insert all values!");
                    return;
                }
                try {
                    double L = Double.parseDouble(length);
                    double h = Double.parseDouble(height);
                    double w = Double.parseDouble(width);
                    double V = L * w *  h;
                    Log.i("PrismDebug", "Volum calculat: " + V);
                    result.setText("V = " + V + " cm^3");
                } catch (NumberFormatException e) {
                    Log.e("PrismDebug", "Valori invalide: " + e.getMessage());
                    result.setText("Please insert only numbers!");
                }
            }
        });

    }
}