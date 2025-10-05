package com.example.frenchteacherapp;

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
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    Button btnBlack, btnGreen, btnPurple, btnRed, btnYellow;
    ProgressBar progressBar;

    Spinner spinner;

    int progress = 0;
    boolean isBlackClicked = true;
    boolean isGreenClicked = true;
    boolean isPurpleClicked = true;
    boolean isRedClicked = true;
    boolean isYellowClicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        btnBlack = findViewById(R.id.btnBlack);
        btnGreen = findViewById(R.id.btnGreen);
        btnPurple = findViewById(R.id.btnPurple);
        btnRed = findViewById(R.id.btnRed);
        btnYellow = findViewById(R.id.btnYellow);
        progressBar = findViewById(R.id.progressBar);

        String[] languages ={"French", "German"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, languages);
        spinner.setAdapter(adapter);
        final boolean[] isFirst = {true};
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isFirst[0]) {
                    isFirst[0] = false;
                    return;
                }
                String selectedLanguage = parent.getItemAtPosition(position).toString();
                if (selectedLanguage.equals("German")) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        btnBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),
                        R.raw.noir);
                mediaPlayer.start();
                if (isBlackClicked){
                    progress = progress + 20;
                    progressBar.setProgress(progress);
                    isBlackClicked = false;

                }
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),
                        R.raw.vert);
                mediaPlayer.start();
                if (isGreenClicked){
                    progress = progress + 20;
                    progressBar.setProgress(progress);
                    isGreenClicked = false;
                }
            }
        });

        btnPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),
                        R.raw.violet);
                mediaPlayer.start();
                if (isPurpleClicked) {
                    progress = progress + 20;
                    progressBar.setProgress(progress);
                    isPurpleClicked = true;
                }
            }
        });

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),
                        R.raw.rouge);
                mediaPlayer.start();
                if (isRedClicked) {
                    progress = progress + 20;
                    progressBar.setProgress(progress);
                    isRedClicked = true;
                }
            }
        });

        btnYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),
                        R.raw.jaune);
                mediaPlayer.start();
                if (isYellowClicked) {
                    progress = progress + 20;
                    progressBar.setProgress(progress);
                    isYellowClicked = true;
                }
            }
        });



    }
}