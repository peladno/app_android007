package com.example.ejercicio1_modulo5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ejercicio1_modulo5.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private TextInputEditText input_url;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        input_url = mainBinding.inputText;
        button = mainBinding.button;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment();
            }
        });
    }

    private void showFragment() {
        webFragment fragment = webFragment.newInstance(Objects.requireNonNull(input_url.getText()).toString());
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(mainBinding.container.getId(), fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}