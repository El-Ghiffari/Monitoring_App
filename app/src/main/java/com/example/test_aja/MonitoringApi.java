package com.example.test_aja;

import java.util.List;
import retrofit2.http.GET;
import retrofit2.Call;

public interface MonitoringApi {
    @GET("/monitoring/HomeSweetHome")
    Call<Post> getPosts();
}
