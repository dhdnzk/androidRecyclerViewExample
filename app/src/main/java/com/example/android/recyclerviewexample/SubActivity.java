package com.example.android.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sub);

        textView = (TextView) findViewById(R.id.tv_sub_activity_display);

        textView.setText(String.valueOf(getIntent().getIntExtra("value", 0)));

    }

}
