package com.d.dao.chineseclassicbook.api;

/**
 * Created by dao on 2017/2/26.
 */

public class Urls {

    public static final String baseUrl = "http://api.jisuapi.com/";
    public static final String DATA_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String APP_KEY = "d48cc4bb226e7c4e";

    //唐诗
    public static final String TangPoems = "http://api.jisuapi.com/tangshi/search";
    //http://api.jisuapi.com/tangshi/search?appkey=yourappkey&keyword=白日

    //宋词
    public static final String SongWords = "http://api.jisuapi.com/songci/search";
    //http://api.jisuapi.com/songci/search?appkey=yourappkey&keyword=扬州慢

    //元曲
    public static final String YuanSongs = "http://api.jisuapi.com/yuanqu/search";
    //http://api.jisuapi.com/yuanqu/search?appkey=yourappkey&keyword=百姓苦


    //老子.道德经
    public static final String TaoTeChing = "http://api.jisuapi.com/laozi/chapter";
    //http://api.jisuapi.com/laozi/chapter?appkey=yourappkey
}
