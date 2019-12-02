package com.michael.pan.pagingnetwork;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

	private static final String BASE_URL = "https://api.stackexchange.com/2.2/";
	private static RetrofitClient INSTANCE;
	private Retrofit retrofit;

	public RetrofitClient() {
		retrofit = new Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.build();
	}

	public static synchronized RetrofitClient getINSTANCE(){
		if (INSTANCE == null){
			INSTANCE = new RetrofitClient();
		}
		return INSTANCE;
	}

	public Api getApi(){
		return retrofit.create(Api.class);
	}

}
