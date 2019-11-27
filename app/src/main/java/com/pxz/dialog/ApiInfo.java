package com.pxz.dialog;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 类说明：
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/9/12 15:05
 */
public interface ApiInfo {
    /**
     * 登录注册
     */
    @FormUrlEncoded
    @POST("/api.php?m=login&a=check&cfrom=mweb")
    Observable<Object> login(@Field("user") String user,
                             @Field("pass") String pass);

    @Headers("Authorization:APPCODEc868a90b992e48678d285ac57c09fa50")
    @GET("/wtr-v3/weather/all")
    Observable<Object> weatherXiaomi(@Query("latitude") String latitude,
                                     @Query("longitude") String longitude,
                                     @Query("locationKey") String locationKey,
                                     @Query("days") String days,
                                     @Query("appKey") String appKey,
                                     @Query("sign") String sign,
                                     @Query("isGlobal") String isGlobal,
                                     @Query("locale") String locale);
}