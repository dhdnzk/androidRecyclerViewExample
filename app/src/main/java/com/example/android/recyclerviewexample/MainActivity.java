package com.example.android.recyclerviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TestAdapter.ItemListClickListener {

    RecyclerView recyclerView;
    TestAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.view_recycler_view);

        adapter = new TestAdapter(100, this);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

    }

    @Override
    public void onListItemClicked(int position) {

        Intent intent = new Intent(this, SubActivity.class);

        intent.putExtra("value", position);

        startActivity(intent);

        Toast.makeText(this, String.valueOf(position) + " is clicked", Toast.LENGTH_SHORT).show();

    }

}
