package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.antbps15545.reviewapp.R;

public class ImageViewExampleFragment extends Fragment {
    ImageView imageView;
    TextView textView;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_image_view_example, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = view.findViewById(R.id.image);
        textView = view.findViewById(R.id.textview);

        view.findViewById(R.id.btn_center).setOnClickListener(clickListener);
        view.findViewById(R.id.btn_centerCrop).setOnClickListener(clickListener);
        view.findViewById(R.id.btn_centerInside).setOnClickListener(clickListener);
        view.findViewById(R.id.btn_fitCenter).setOnClickListener(clickListener);
        view.findViewById(R.id.btn_fitEnd).setOnClickListener(clickListener);
        view.findViewById(R.id.btn_fitStart).setOnClickListener(clickListener);
        view.findViewById(R.id.btn_fitXY).setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ImageView.ScaleType scaletype = ImageView.ScaleType.CENTER;
            switch (view.getId())
            {
                case R.id.btn_center:
                    scaletype = ImageView.ScaleType.CENTER;
                    break;
                case R.id.btn_centerCrop:
                    scaletype = ImageView.ScaleType.CENTER_CROP;
                    break;
                case R.id.btn_centerInside:
                    scaletype = ImageView.ScaleType.CENTER_INSIDE;
                    break;
                case R.id.btn_fitCenter:
                    scaletype = ImageView.ScaleType.FIT_CENTER;
                    break;
                case R.id.btn_fitEnd:
                    scaletype = ImageView.ScaleType.FIT_END;
                    break;
                case R.id.btn_fitStart:
                    scaletype = ImageView.ScaleType.FIT_START;
                    break;
                case R.id.btn_fitXY:
                    scaletype = ImageView.ScaleType.FIT_XY;
                    break;

            }

            imageView.setScaleType(scaletype);
            textView.setText(((Button)view).getText());
        }
    };
}