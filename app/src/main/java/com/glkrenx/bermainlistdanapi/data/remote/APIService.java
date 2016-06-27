package com.glkrenx.bermainlistdanapi.data.remote;

import com.glkrenx.bermainlistdanapi.model.get.APIResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by glkrenx on 24/06/16.
 */
public interface APIService {
    public static final String API_URL = "http://data.go.id/api/action/";

    @GET("datastore_search?")
    Call<APIResponse> getResult(@Query("resource_id") String API_KEY,
                                @Query("limit") int SORT);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    APIService service = retrofit.create(APIService.class);
}
