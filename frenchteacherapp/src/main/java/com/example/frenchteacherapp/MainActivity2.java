package com.example.frenchteacherapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private Button btnBlack, btnGreen, btnPurple, btnRed, btnYellow;
    private ProgressBar progressBar;
    private Spinner spinner;

    private int progress1 = 0;
    private boolean isBlackClicked = true, isGreenClicked = true,
            isPurpleClicked = true, isRedClicked = true, isYellowClicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        spinner = findViewById(R.id.spinner);
        btnBlack = findViewById(R.id.btnBlack);
        btnGreen = findViewById(R.id.btnGreen);
        btnPurple = findViewById(R.id.btnPurple);
        btnRed = findViewById(R.id.btnRed);
        btnYellow = findViewById(R.id.btnYellow);
        progressBar = findViewById(R.id.progressBar);

        String[] languages = {"French", "German"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, languages);
        spinner.setAdapter(adapter);

        int germanPos = adapter.getPosition("German");
        spinner.setSelection(germanPos);

        final boolean[] isFirst = {true};
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isFirst[0]) {
                    isFirst[0] = false;
                    return;
                }
                // Determine which language was picked
                String selected = parent.getItemAtPosition(position).toString();
                if ("French".equals(selected)) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        btnBlack.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.schwarz);
            mp.start();
            if (isBlackClicked) {
                progress1 += 20;
                progressBar.setProgress(progress1);
                isBlackClicked = false;
            }
        });

        btnGreen.setOnClickListener(v -> {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.grun);
                    mp.start();
                    if (isGreenClicked) {
                        progress1 += 20;
                        progressBar.setProgress(progress1);
                        isGreenClicked = false;
                    }
        });

        btnPurple.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.lila);
            mp.start();
            if (isPurpleClicked) {
                progress1 += 20;
                progressBar.setProgress(progress1);
                isPurpleClicked = false;
            }
        });

        btnRed.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.rot);
            mp.start();
            if (isRedClicked) {
                progress1 += 20;
                progressBar.setProgress(progress1);
                isRedClicked = false;
            }
        });

        btnYellow.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.gelb);
            mp.start();
            if (isYellowClicked) {
                progress1 += 20;
                progressBar.setProgress(progress1);
                isYellowClicked = false;
            }
        });

    }
}
