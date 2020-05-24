package com.example.esiea;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

abstract class BaseActivity  extends AppCompatActivity
{
public void showBaseError ()
{
    //affiche erreur
    Toast.makeText(this,"Erreur", Toast.LENGTH_LONG).show();
}
}
