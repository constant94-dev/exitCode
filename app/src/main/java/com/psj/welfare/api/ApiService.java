package com.psj.welfare.api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

	@FormUrlEncoded
	@POST("/backend/android/and_detail.php")
	Call<JsonObject> detailData(@Field("be_name") String detail);

	@FormUrlEncoded
	@POST("/backend/android/and_category_result.php")
	Call<String> mainFavor(@Field("reqBody") String mainFavor);

	@FormUrlEncoded
	@POST("/backend/android/and_search.php")
	Call<String> search(@Field("reqBody") String search);

	@FormUrlEncoded
	@POST("/backend/android/and_level_select.php")
	Call<String> category1(@Field("category1_name") String category, @Field("level") String level);

	@FormUrlEncoded
	@POST("/backend/android/and_level_select.php")
	Call<String> category2(@Field("category1_name") String category_first, @Field("category2_name") String category_second, @Field("level") String level);

	@FormUrlEncoded
	@POST("/backend/android/and_level_select.php")
	Call<String> category3(@Field("category1_name") String category_first, @Field("category2_name") String category_second, @Field("category3_name") String category_third, @Field("level") String level);

	@FormUrlEncoded
	@POST("/backend/android/and_fcm_token_save.php")
	Call<String> fcmToken(@Field("userEmail") String userEmail, @Field("fcm_token") String fcm_token);

}
