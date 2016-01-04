package com.kurio.kurator.kuratorapps.Login.ApiLogin;

import com.kurio.kurator.kuratorapps.Login.Model.Admin;


import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Jimmy Christian on 1/4/2016.
 */
public interface ApiLogin {
    @GET("/feeds/flowers.json")
    public void getData(Callback<Admin> response);

    @FormUrlEncoded
    @POST("index.php?k=test&c=2")
    Call<Admin> postLogin(@Field("email") String email, @Field("password") String password);

}
