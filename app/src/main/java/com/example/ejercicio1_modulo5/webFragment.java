package com.example.ejercicio1_modulo5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ejercicio1_modulo5.databinding.FragmentWebBinding;

public class webFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private String url;

    private FragmentWebBinding fragmentWebBinding;

    public webFragment() {

    }

    public static webFragment newInstance(String url) {
        webFragment fragment = new webFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, url);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentWebBinding = FragmentWebBinding.inflate(inflater, container, false);
        View view = fragmentWebBinding.getRoot();

        WebView webView = fragmentWebBinding.webview;
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
        String url1 = url.trim();
        webView.loadUrl(url1);
        return view;

    }
}