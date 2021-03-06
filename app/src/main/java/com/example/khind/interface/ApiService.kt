package com.example.khind.`interface`

import com.example.khind.model.*
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("auth/sign_in")
    fun login(
        @Query("email") email: String,
        @Query("password") password: String
    ): Call<ResponseLogin>

    @POST("auth/refresh_token")
    fun refreshToken(
        @Header("X-Refresh-Token") token: String,
        @Query("refresh_token") reToken: String
    ): Call<RefreshToken>

    @GET("sensors")
    fun getSensors(@Header("X-Http-Token") token: String): Call<ResponseSensor>

    @GET("sensors/{id}")
    fun getDetailSensor(
        @Header("X-Http-Token") token: String,
        @Path("id") sensorID: String
    ): Call<DetailSensor>

    @GET("messages")
    fun getMessage(
        @Header("X-Http-Token") token: String,
        @Query("page") page: Int
    ): Call<ResponseMessage>

    @FormUrlEncoded
    @PUT("users/change_password")
    fun changePassword(
        @Header("X-Http-Token") token: String,
        @Field("password") password: String,
        @Field("password_confirmation") confirmPass: String,
        @Field("current_password") currentPass: String
    ): Call<ResponseChangePass>

    @Multipart
    @PUT("users/avatar")
    fun changeAvatar(
        @Header("X-Http-Token") token: String,
        @Part avt: MultipartBody.Part
    ): Call<ResponseChangeAvatar>
}