package com.d.dao.chineseclassicbook.ui.splash;

import android.content.Intent;
import android.os.Handler;

import com.baidu.appx.BDBannerAd;
import com.baidu.appx.BDInterstitialAd;
import com.baidu.appx.BDSplashAd;
import com.d.dao.chineseclassicbook.R;
import com.d.dao.chineseclassicbook.ui.home.HomeActivity;
import com.d.dao.zlibrary.base.activity.ZBaseWelcomeActivity;
import com.socks.library.KLog;


/**
 * Created by dao on 2017/2/25.
 */

public class SplashActivity extends ZBaseWelcomeActivity {

    private BDSplashAd splashAd = null;

    private String SDK_APP_KEY = "hYiRMsMTgrnP8HyIbMDYgqyjtMxq2EY7";
    private String SDK_SPLASH_AD_ID = "ZxDKHHERj3LMKs8yXGjMKCEG";

    /**
     * 布局Id
     *
     * @return
     */
    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    private class AdListener implements BDBannerAd.BannerAdListener, BDInterstitialAd.InterstitialAdListener, BDSplashAd.SplashAdListener {


        @Override
        public void onAdvertisementDataDidLoadFailure() {
            KLog.e("ad did load failure");
//            gotoHomeAfterSeconds(5000);
        }

        @Override
        public void onAdvertisementDataDidLoadSuccess() {
            KLog.e("ad did load success");
        }

        @Override
        public void onAdvertisementViewDidClick() {
            KLog.e("ad view did click");
        }

        @Override
        public void onAdvertisementViewDidShow() {
            KLog.e("ad view did show");
        }

        @Override
        public void onAdvertisementViewWillStartNewIntent() {
            KLog.e("ad view will new intent");
        }

        @Override
        public void onAdvertisementViewDidHide() {
            KLog.e("ad view did hide");
//            gotoHome();
        }

    }


    /**
     * 初始化视图
     */
    @Override
    public void initView() {
        if (null == splashAd) {
            splashAd = new BDSplashAd(this, SDK_APP_KEY, SDK_SPLASH_AD_ID);
            splashAd.setAdListener(new AdListener());
        }
        //如果本地无广告可用，需要下载广告，待下次启动使用
        if (!splashAd.isLoaded()) {
            KLog.e("下载广告，下次使用");
            splashAd.loadAd();
            gotoHome();
        }
        //展示开屏广告
        else {
            KLog.e("有广告");
            splashAd.showAd();

        }
    }

    private void gotoHomeAfterSeconds(int seconds) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gotoHome();
                //进入动画
            }
        }, seconds);
    }

    private void gotoHome() {
        Intent intent = new Intent(mContext, HomeActivity.class);
        startActivity(intent);
        finish();
    }
//

    //
    @Override
    protected void onDestroy() {
        if (splashAd != null) {
            splashAd.destroy();
            splashAd = null;
        }
        super.onDestroy();
    }
}