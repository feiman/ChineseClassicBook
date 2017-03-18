package com.d.dao.chineseclassicbook.api;

import com.d.dao.chineseclassicbook.bean.TangResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dao on 2017/2/18.
 */

public interface ApiService {


    /**
     * 唐诗
     * 搜索
     *
     * @param appKey  appkey
     * @param keyword 关键词
     * @param pageNum 当前要查询的页数
     * @return
     */
    @GET("tangshi/search")
    Observable<String> queryTang(@Query("appkey") String appKey,
                                 @Query("keyword") String keyword,
                                 @Query("pagenum") int pageNum,
                                 @Query("pagesize") int pageSize);


    /**
     * 宋词
     * 搜索
     *
     * @param appKey  appkey
     * @param keyword 关键词
     * @param pageNum 当前要查询的页数
     * @return
     */
    @GET("songci/search")
    Observable<TangResult> querySong(@Query("appkey") String appKey,
                                     @Query("keyword") String keyword,
                                     @Query("pagenum") int pageNum,
                                     @Query("pagesize") int pageSize);


    /**
     * 元曲
     * 搜索
     *
     * @param appKey  appkey
     * @param keyword 关键词
     * @param pageNum 当前要查询的页数
     * @return
     */
    @GET("yuanqu/search")
    Observable<TangResult> queryYuan(@Query("appkey") String appKey,
                                     @Query("keyword") String keyword,
                                     @Query("pagenum") int pageNum,
                                     @Query("pagesize") int pageSize);

    /**
     * 老子*道德经
     * 获取章节
     *
     * @return
     */
    @GET("laozi/chapter")
    Observable<String> queryChapter(@Query("appkey") String appKey);

    /**
     * 老子道德经
     * 搜索
     */
    @GET("laozi/search")
    Observable<String> queryLaoZi(@Query("appkey") String appKey,
                                  @Query("keyword") String keyword,
                                  @Query("isdetailed") int isdetailed,
                                  @Query("pagenum") int pageNum,
                                  @Query("pagesize") int pageSize);
}