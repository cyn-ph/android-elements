package com.test.abc.data;

import com.test.abc.beans.FoodResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FoodAPI {
    @GET("/icebox/v1/foods/{language}/{country}/{search}")
    Observable<FoodResponse> searchFood(@Path("language") String language,
                                        @Path("country") String country,
                                        @Path("search") String query);
}
