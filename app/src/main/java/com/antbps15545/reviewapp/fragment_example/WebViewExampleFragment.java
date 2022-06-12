package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.antbps15545.reviewapp.MyWebViewClient;
import com.antbps15545.reviewapp.R;


public class WebViewExampleFragment extends Fragment {
    private EditText addressBar;
    View view;
    private WebView webView;
    private Button buttonGo;
    private Button buttonStatic;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_web_view_example, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonGo =(Button)view.findViewById(R.id.button_go);
        buttonStatic =(Button)view.findViewById(R.id.button_static);

        addressBar =(EditText)view.findViewById(R.id.editText_addressBar);
        webView =(WebView)view.findViewById(R.id.webView);

        // Tùy biến WebViewClient để điều khiển các sự kiện trên WebView
        webView.setWebViewClient(new MyWebViewClient(addressBar));

        buttonGo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                goUrl();
            }
        });

        buttonStatic.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStaticContent();
            }
        });
    }
    private void goUrl()  {
        String url = addressBar.getText().toString().trim();
        if(url.isEmpty())  {
            Toast.makeText(getContext(),"Please enter url", Toast.LENGTH_SHORT).show();
            return;
        }
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
    }


    private void showStaticContent()  {
        String staticContent="<h2>Select web page</h2>"
                + "<ul><li><a href='http://eclipse.org'>Eclipse</a></li>"
                +"<li><a href='http://google.com'>Google</a></li></ul>";
        webView.loadData(staticContent, "text/html", "UTF-8");
    }
}