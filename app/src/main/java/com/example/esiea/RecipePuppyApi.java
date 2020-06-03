package com.example.esiea;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipePuppyApi
{
    @GET("api.php?amount=10")
    Call<RestRecipePuppy> getRecipePuppyResponse();
}
