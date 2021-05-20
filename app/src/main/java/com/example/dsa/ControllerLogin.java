package com.example.dsa;

import android.view.View;
import android.widget.Toast;

import com.example.dsa.models.Credentials;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControllerLogin implements Callback<Void> {

    static final String BASE_URL = "http://10.0.2.2:8080/";
    Toast t;
    MainActivity main;

    public void start(MainActivity main, Credentials c) {
        this.main = main;
        this.t = main.toast;

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        Server server = retrofit.create(Server.class);

        Call<Void> call = server.login(c);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Void> call, Response<Void> response) {
        if(response.isSuccessful()) {
            System.out.println("Login successful!");
            Toast.makeText(main.getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
        } else {
            System.out.println("Error: " + response.errorBody());
            Toast.makeText(main.getApplicationContext(), "Error: Wrong credentials.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<Void> call, Throwable t) {
        Toast.makeText(main.getApplicationContext(), "Unexpected error.", Toast.LENGTH_LONG).show();
        t.printStackTrace();
    }
}