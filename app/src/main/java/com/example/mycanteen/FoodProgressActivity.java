package com.example.mycanteen;

// FoodProgressActivity.java
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodProgressActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView tvProgressStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);

        progressBar = findViewById(R.id.progressBar);
        tvProgressStatus = findViewById(R.id.tvProgressStatus);

        // Simulating food progress
        simulateFoodProgress();
    }

    private void simulateFoodProgress() {
        final int totalProgress = 100;
        final int progressInterval = 10; // Update the progress every 10 seconds

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            int progress = 0;

            @Override
            public void run() {
                if (progress <= totalProgress) {
                    // Update progress
                    progressBar.setProgress(progress);

                    // Update progress status
                    updateProgressStatus(progress);

                    // Increment progress
                    progress += progressInterval;

                    // Schedule the next update
                    handler.postDelayed(this, 10000); // 10000 milliseconds (10 seconds)
                } else {
                    // Food progress completed, you can navigate to the next activity or perform any other action
                    // For example, go to a confirmation page
                    finish();
                }
            }
        }, 0); // Start immediately
    }

    private void updateProgressStatus(int progress) {
        if (progress == 0) {
            tvProgressStatus.setText("Food Ordered");
        } else if (progress < 100) {
            tvProgressStatus.setText("Food is Cooking");
        } else if (progress == 100) {
            tvProgressStatus.setText("Food is Ready. Please take your order.");
        } else {
            tvProgressStatus.setText("Food is Taken");
        }
    }

}
