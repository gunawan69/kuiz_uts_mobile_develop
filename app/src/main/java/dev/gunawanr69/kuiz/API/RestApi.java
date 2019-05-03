package dev.gunawanr69.kuiz.API;

import dev.gunawanr69.kuiz.MODEL.ResponseModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApi {
    //insert
    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseModel> sendWeb(@Field("kode") String kode,
                                    @Field("nama") String nama,
                                    @Field("url") String url,
                                    @Field("pemilik") String pemilik);
    //read
    @GET("read.php")
    Call<ResponseModel> getWeb();
    //update menggunakan 3 parameter
    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseModel> updateData( @Field("id") String id,
                                    @Field("kode") String kode,
                                    @Field("nama") String nama,
                                    @Field("url") String url,
                                    @Field("pemilik") String pemilik);

    //delete menggunakan parameter id
    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseModel> deleteData(@Field("id") String id);
}
