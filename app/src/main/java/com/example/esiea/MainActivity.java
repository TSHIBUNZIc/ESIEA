package com.example.esiea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
    // use a linear layout manager
    layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    List<String> input = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
    input.add("Test" + i);
}// define an adapter
    mAdapter = new ListAdapter(input);
        recyclerView.setAdapter(mAdapter);
}

        //Button mainButton = findViewById(R.id.main_button);
         //mainButton
       /* mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"Onclicked", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"Onclicked", Toast.LENGTH_LONG).show();
            }
        });
        Film film = new Film("lion" ,100 );
        showBaseError();*/
    }


    /*public void showList(List<Film> list) {
// mettre le vrai code ici
    }

    @Override
    public void showLoader() {

    }

    @Override
    public void showError() {

    }*/

