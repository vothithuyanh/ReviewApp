package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.antbps15545.reviewapp.R;


public class ProgressBarExampleFragment extends Fragment {
    private Button buttonStart1;
    private Button buttonStart2;
    private ProgressBar progressBar1;
    private ProgressBar progressBar2;
    View view;
    private TextView textViewInfo1;
    private TextView textViewInfo2;

    private Handler handler = new Handler();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_progress_bar_example, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.progressBar1 = (ProgressBar) this.view.findViewById(R.id.progressBar1);
        this.progressBar2 = (ProgressBar) this.view.findViewById(R.id.progressBar2);
        this.progressBar2.setIndeterminate(false);

        this.textViewInfo1 = (TextView) this.view.findViewById(R.id.textView_info1);
        this.textViewInfo2 = (TextView) this.view.findViewById(R.id.textView_info2);


        this.buttonStart1 = (Button) this.view.findViewById(R.id.button_start1);
        this.buttonStart2 = (Button) this.view.findViewById(R.id.button_start2);

        this.buttonStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doStartProgressBar1();
            }
        });

        this.buttonStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doStartProgressBar2();
            }
        });
    }

    private void doStartProgressBar1()  {
        final int MAX = 110;
        this.progressBar1.setMax(MAX);

        Thread thread = new Thread(new Runnable()  {

            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        buttonStart1.setEnabled(false);
                    }
                });
                for( int i =0; i < MAX; i++) {
                    final int progress = i + 1;
                    // Do something (Download, Upload, Update database,..)
                    SystemClock.sleep(20); // Sleep 20 milliseconds.

                    // Update interface.
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar1.setProgress(progress);
                            int percent = (progress * 100) / MAX;

                            textViewInfo1.setText("Percent: " + percent + " %");
                            if(progress == MAX)  {
                                textViewInfo1.setText("Completed!");
                                buttonStart1.setEnabled(true);
                            }
                        }
                    });
                }
            }
        });
        thread.start();
    }

    private void doStartProgressBar2()  {
        this.progressBar2.setIndeterminate(true);

        Thread thread = new Thread(new Runnable()  {

            @Override
            public void run() {
                // Update interface
                handler.post(new Runnable() {
                    public void run() {
                        textViewInfo2.setText("Working...");
                        buttonStart2.setEnabled(false);
                    }
                });
                // Do something ... (Update database,..)
                SystemClock.sleep(5000); // Sleep 5 seconds.

                progressBar2.setIndeterminate(false);
                progressBar2.setMax(1);
                progressBar2.setProgress(1);

                // Update interface
                handler.post(new Runnable() {
                    public void run() {
                        textViewInfo2.setText("Completed!");
                        buttonStart2.setEnabled(true);
                    }
                });
            }
        });
        thread.start();
    }
}