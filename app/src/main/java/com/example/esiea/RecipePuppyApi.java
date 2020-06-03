package com.example.esiea;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipePuppyApi
{
    @GET("api/v2/pokemon")
    Call<RestRecipePuppy> getRecipePuppyResponse();
}
