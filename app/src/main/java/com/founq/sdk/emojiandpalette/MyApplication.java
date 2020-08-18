package com.founq.sdk.emojiandpalette;

import android.app.Application;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.emoji.bundled.BundledEmojiCompatConfig;
import androidx.emoji.text.EmojiCompat;

/**
 * Created by ring on 2020/8/18.
 * 记着，写public，要不，崩溃
 */
public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        loadEmojiFromBundled();
    }


    /**
     * 初始化EmojiCompat的方法，需要在使用之前调用，否则会报错
     */
    private void loadEmojiFromBundled() {
        EmojiCompat.Config config = new BundledEmojiCompatConfig(getApplicationContext());

        config.setReplaceAll(true)
                .registerInitCallback(new EmojiCompat.InitCallback() {
                    @Override
                    public void onInitialized() {
                        Log.i(TAG, "loadEmojiFromBundled()->onInitialized()");
                    }

                    @Override
                    public void onFailed(@Nullable Throwable throwable) {
                        Log.e(TAG, "loadEmojiFromBundled()->onFailed()", throwable);
                    }
                });

        EmojiCompat.init(config);
    }
}
