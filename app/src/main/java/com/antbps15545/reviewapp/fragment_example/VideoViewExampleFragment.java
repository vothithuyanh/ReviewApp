package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antbps15545.reviewapp.R;
import com.antbps15545.reviewapp.utils.VideoViewUtils;

public class VideoViewExampleFragment extends Fragment {

    private VideoView videoView;
    private int position = 0;
    private MediaController mediaController;
    private Button buttonRaw;
    private Button buttonLocal;
    private Button buttonURL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video_view_example, container, false);

        this.videoView = (VideoView) view.findViewById(R.id.videoView);
        this.buttonRaw = (Button) view.findViewById(R.id.button_raw);
        this.buttonLocal = (Button) view.findViewById(R.id.button_local );
        this.buttonURL = (Button) view.findViewById(R.id.button_url);

        // Set the media controller buttons
        if (this.mediaController == null) {
            this.mediaController = new MediaController(getContext());

            // Set the videoView that acts as the anchor for the MediaController.
            this.mediaController.setAnchorView(videoView);

            // Set MediaController for VideoView
            this.videoView.setMediaController(mediaController);
        }

        this.videoView.setOnPreparedListener(new OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {

                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                }

                // When video Screen change size.
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        // Re-Set the videoView that acts as the anchor for the MediaController
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });

        this.buttonRaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // "myvideo.mp4" in directory "raw".
                String resName = VideoViewUtils.RAW_VIDEO_SAMPLE;
                VideoViewUtils.playRawVideo(getContext(), videoView, resName);
            }
        });

        this.buttonLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String localPath = VideoViewUtils.LOCAL_VIDEO_SAMPLE;
                VideoViewUtils.playLocalVideo(getContext(), videoView, localPath);
            }
        });

        this.buttonURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoURL = VideoViewUtils.URL_VIDEO_SAMPLE;
                VideoViewUtils.playURLVideo(getContext(), videoView, videoURL);
            }
        });
        return view;
    }
    
    // When you change direction of phone, this method will be called.
    // It store the state of video (Current position)
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Store current position.
        savedInstanceState.putInt("CurrentPosition", videoView.getCurrentPosition());
        videoView.pause();
    }
    
    // After rotating the phone. This method is called.

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState!= null){
            position = savedInstanceState.getInt("CurrentPosition");
            videoView.seekTo(position);
        }

    }
}