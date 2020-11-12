package com.example.customlist;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    TextView name;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        name = findViewById(R.id.tv1);
        imageView = findViewById(R.id.anh);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        imageView.setImageResource(intent.getIntExtra("image", 0));
    }
}