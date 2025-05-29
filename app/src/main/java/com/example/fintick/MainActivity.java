package com.example.fintick;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fintick.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Links this activity to its UI layout
    }
}