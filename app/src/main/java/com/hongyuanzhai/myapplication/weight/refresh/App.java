package com.hongyuanzhai.myapplication.weight.refresh;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.hongyuanzhai.myapplication.Service.DownloadService;


/**
 */

public class App extends Application {
    private static Context sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        startService(new Intent(getContext(), DownloadService.class));

//        // 初始化内存分析工具
//        if (!LeakCanary.isInAnalyzerProcess(this)) {
//            LeakCanary.install(this);
//        }
    }

    public static Context getContext(){
        return sInstance;
    }
}