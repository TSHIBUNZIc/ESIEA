package com.example.esiea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends BaseActivity implements MainInterface  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mainButton = findViewById(R.id.main_button);
         //mainButton
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"Onclicked", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"Onclicked", Toast.LENGTH_LONG).show();
            }
        });
        Film film = new Film("lion" ,100 );
        showBaseError();
    }

    @Override
    public void showList(List<Film> list) {
// mettre le vrai code ici
    }

    @Override
    public void showLoader() {

    }

    @Override
    public void showError() {

    }
}
