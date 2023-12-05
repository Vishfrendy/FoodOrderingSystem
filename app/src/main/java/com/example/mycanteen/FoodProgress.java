package com.example.mycanteen;

// ProgressActivity.java
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodProgress extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView tvProgressPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);

        progressBar = findViewById(R.id.progressBar);
        tvProgressPercentage = findViewById(R.id.tvProgressPercentage);

        // Simulating food preparation progress
        simulateFoodPreparation();
    }

    private void simulateFoodPreparation() {
        final int totalProgress = 100;
        final int progressInterval = 10; // Update 1% every 5 seconds

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            int progress = 0;

            @Override
            public void run() {
                if (progress <= totalProgress) {
                    // Update progress
                    progressBar.setProgress(progress);
                    tvProgressPercentage.setText(progress + "%");

                    // Increment progress
                    progress += progressInterval;

                    // Schedule the next update
                    handler.postDelayed(this, 5000); // 5000 milliseconds (5 seconds)
                } else {
                    // Food preparation completed, you can navigate to the next activity or perform any other action
                    // For example, go to a confirmation page
                    finish();
                }
            }
        }, 0); // Start immediately
    }
}

