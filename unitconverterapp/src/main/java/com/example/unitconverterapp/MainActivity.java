package com.example.unitconverterapp;

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

public class MainActivity extends AppCompatActivity {
    EditText title_text, insert_text;
    TextView textView2, textView3;
    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        title_text = findViewById(R.id.title_text);
        insert_text = findViewById(R.id.insert_text);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        myButton = findViewById(R.id.myButton);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = insert_text.getText().toString();
                double kilos = Double.parseDouble(inputText);

                double pounds = makeConversion(kilos);
                textView3.setText("" + pounds);
            }
        });
    }

    public double makeConversion(double kilos){
        //1 kilo = 2.20462
        return kilos*2.20462;
    }
}