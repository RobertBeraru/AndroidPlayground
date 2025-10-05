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

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private Button btnBlack, btnGreen, btnPurple, btnRed, btnYellow;
    private ProgressBar progressBar;
    private Spinner spinner;

    private int progress = 0;
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

        btnBlack.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnPurple.setOnClickListener(this);
        btnRed.setOnClickListener(this);
        btnYellow.setOnClickListener(this);

    }
    public void PlaySounds(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),
                id);
        mediaPlayer.start();
    }

    @Override
    public void onClick(View v) {
        int clickedBtnId = v.getId();

        if (clickedBtnId == R.id.btnBlack){
            if (isBlackClicked){
                progress = progress + 20;
                progressBar.setProgress(progress);
                isBlackClicked = false;

            }
            PlaySounds(R.raw.schwarz);
        } else if (clickedBtnId == R.id.btnGreen) {
            if (isGreenClicked){
                progress = progress + 20;
                progressBar.setProgress(progress);
                isGreenClicked = false;
            }
            PlaySounds(R.raw.grun);
        } else if (clickedBtnId == R.id.btnPurple) {
            if (isPurpleClicked) {
                progress = progress + 20;
                progressBar.setProgress(progress);
                isPurpleClicked = true;
            }
            PlaySounds(R.raw.lila);
        } else if (clickedBtnId == R.id.btnRed) {
            if (isRedClicked) {
                progress = progress + 20;
                progressBar.setProgress(progress);
                isRedClicked = true;
            }
            PlaySounds(R.raw.rot);
        } else if (clickedBtnId == R.id.btnYellow) {
            if (isYellowClicked) {
                progress = progress + 20;
                progressBar.setProgress(progress);
                isYellowClicked = true;
            }
            PlaySounds(R.raw.gelb);
        }
    }
}
