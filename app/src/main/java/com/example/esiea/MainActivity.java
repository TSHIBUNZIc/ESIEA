package com.example.esiea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private static final String BASE_URL = "https://pokeapi.co/";
private SharedPreferences sharedPreferences;
private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("application_esiea", Context.MODE_PRIVATE);
        //showList();
        gson = new GsonBuilder()
                .setLenient()
                .create();
        List< RecipePuppy> recipePuppyList = getDataFromCache();
        if(recipePuppyList != null)
        {
            showList(recipePuppyList);
        }
        else
        {
            makeApiCall();
        }
    }
    private List<RecipePuppy> getDataFromCache()
    {
        String jsonRecipe = sharedPreferences.getString( Constant.KEY_RECIPEPUPPY_LIST, null);
        if(jsonRecipe == null)
        {return null;
        } else {
        Type listType = new TypeToken<List<RecipePuppy>>(){}.getType();
        return gson.fromJson(jsonRecipe, listType);}

    }
    private void showList(List< RecipePuppy> recipePuppyList)
    {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
    // use a linear layout manager
    layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // define an adapter
    mAdapter = new ListAdapter(recipePuppyList);
        recyclerView.setAdapter(mAdapter);
}

       private void makeApiCall ()
       {
           //Gson gson = new GsonBuilder()
                   //.setLenient()
                   //.create();

           Retrofit retrofit = new Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create(gson))
                   .build();

           RecipePuppyApi recipePuppyApi = retrofit.create(RecipePuppyApi.class);

           Call<RestRecipePuppy> call = recipePuppyApi.getRecipePuppyResponse();
           call.enqueue(new Callback<RestRecipePuppy>()
           {
               @Override
               public void onResponse(Call<RestRecipePuppy> call, Response<RestRecipePuppy> response)
               {
                   if (response.isSuccessful() && response.body() != null)
                   {
                       List<RecipePuppy> recipePuppyList = response.body().getResults();
                       //Toast.makeText( getApplicationContext(),"API Success", Toast.LENGTH_SHORT).show();
                       saveList(recipePuppyList);
                       showList(recipePuppyList);
                   }
                   else
                   {
                       showError();
                   }
               }
               @Override
               public void onFailure(Call<RestRecipePuppy> call, Throwable t)
               {
                showError();
               }
           });
           //call.enqueue (this);
       }
       private void saveList(List<RecipePuppy> recipePuppyList)
       {
           String jsonString = gson.toJson(recipePuppyList);
           sharedPreferences
                   .edit()
                   .putString(Constant.KEY_RECIPEPUPPY_LIST, jsonString)
                   .apply();
           Toast.makeText(getApplicationContext(), "list saved" , Toast.LENGTH_SHORT).show();
       }

    private void showError()
    {
        Toast.makeText(getApplicationContext(), "API Error" , Toast.LENGTH_SHORT).show();
    }
}




