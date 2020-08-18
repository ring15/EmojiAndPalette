package com.founq.sdk.emojiandpalette;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

public class MainActivity extends AppCompatActivity {

    private ImageView ivGirl;

    private TextView tvVibrant;
    private TextView tvVibrantDark;
    private TextView tvVibrantLight;
    private TextView tvMuted;
    private TextView tvMutedDark;
    private TextView tvMutedLight;
    // 颜色加深处理
    private TextView tvVibrantBurn;
    private TextView tvVibrantDarkBurn;
    private TextView tvVibrantLightBurn;
    //颜色浅化处理
    private TextView tvMutedShallow;
    private TextView tvMutedDarkShallow;
    private TextView tvMutedLightShallow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        ivGirl = findViewById(R.id.img_girl);
        tvVibrant = findViewById(R.id.tv_palette_vibrant);
        tvVibrantDark = findViewById(R.id.tv_palette_vibrant_dark);
        tvVibrantLight = findViewById(R.id.tv_palette_vibrant_light);
        tvMuted = findViewById(R.id.tv_palette_muted);
        tvMutedDark = findViewById(R.id.tv_palette_muted_dark);
        tvMutedLight = findViewById(R.id.tv_palette_muted_light);
        tvVibrantBurn = findViewById(R.id.tv_palette_vibrant_burn);
        tvVibrantDarkBurn = findViewById(R.id.tv_palette_vibrant_dark_burn);
        tvVibrantLightBurn = findViewById(R.id.tv_palette_vibrant_light_burn);
        tvMutedShallow = findViewById(R.id.tv_palette_muted_shallow);
        tvMutedDarkShallow = findViewById(R.id.tv_palette_muted_dark_shallow);
        tvMutedLightShallow = findViewById(R.id.tv_palette_muted_light_shallow);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                startActivity(new Intent(this, EmojiActivity.class));
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPalette(getBitmap(ivGirl));
    }

    private void getPalette(Bitmap bitmap) {
        if (bitmap != null) {
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(@Nullable Palette palette) {
                    if (palette != null) {
                        Palette.Swatch vibrant = palette.getVibrantSwatch();//有活力的
                        tvVibrant.setText("有活力的");
                        tvVibrantBurn.setText("有活力的-加深");
                        if (vibrant != null) {
                            tvVibrant.setBackgroundColor(vibrant.getRgb());
                            tvVibrantBurn.setBackgroundColor(setColorBurn(vibrant.getRgb(), 0.3f));
                        }

                        Palette.Swatch vibrantDark = palette.getDarkVibrantSwatch();//有活力的暗色
                        tvVibrantDark.setText("有活力的暗色");
                        tvVibrantDarkBurn.setText("有活力的暗色-加深");
                        if (vibrantDark != null) {
                            tvVibrantDark.setBackgroundColor(vibrantDark.getRgb());
                            tvVibrantDarkBurn.setBackgroundColor(setColorBurn(vibrantDark.getRgb(), 0.3f));
                        }

                        Palette.Swatch vibrantLight = palette.getLightVibrantSwatch();//有活力的亮色
                        tvVibrantLight.setText("有活力的亮色");
                        tvVibrantLightBurn.setText("有活力的亮色-加深");
                        if (vibrantLight != null) {
                            tvVibrantLight.setBackgroundColor(vibrantLight.getRgb());
                            tvVibrantLightBurn.setBackgroundColor(setColorBurn(vibrantLight.getRgb(), 0.3f));
                        }

                        Palette.Swatch muted = palette.getMutedSwatch();//柔和的
                        tvMuted.setText("柔和的");
                        tvMutedShallow.setText("柔和的-浅化");
                        if (muted != null) {
                            tvMuted.setBackgroundColor(muted.getRgb());
                            tvMutedShallow.setBackgroundColor(setColorShallow(muted.getRgb(), 0.3f));
                        }

                        Palette.Swatch mutedDark = palette.getDarkMutedSwatch();//柔和的暗色
                        tvMutedDark.setText("柔和的暗色");
                        tvMutedDarkShallow.setText("柔和的暗色-浅化");
                        if (mutedDark != null) {
                            tvMutedDark.setBackgroundColor(mutedDark.getRgb());
                            tvMutedDarkShallow.setBackgroundColor(setColorShallow(mutedDark.getRgb(), 0.3f));
                        }

                        Palette.Swatch mutedLight = palette.getLightMutedSwatch();//柔和的亮色
                        tvMutedLight.setText("柔和的亮色");
                        tvMutedLightShallow.setText("柔和的亮色-浅化");
                        if (mutedLight != null) {
                            tvMutedLight.setBackgroundColor(mutedLight.getRgb());
                            tvMutedLightShallow.setBackgroundColor(setColorShallow(mutedLight.getRgb(), 0.2f));
                        }
                    }
                }
            });
        }
    }

//    private void initPalette() {
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
//        // 同步
////        Palette palette=Palette.from(bitmap).generate();
//        // 异步,由于我们获取的颜色一般都需要设置到控件来，所以采用的基本都是异步的方式来获取主色调
//        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//            @Override
//            public void onGenerated(@Nullable Palette palette) {
//                if (palette != null) {
////                    Palette.Swatch vibrant = palette.getVibrantSwatch();//有活力的
////                    Palette.Swatch vibrantDark = palette.getDarkVibrantSwatch();//有活力的暗色
////                    Palette.Swatch vibrantLight = palette.getLightVibrantSwatch();//有活力的亮色
////
////                    Palette.Swatch muted = palette.getMutedSwatch();//柔和的
////                    Palette.Swatch mutedDark = palette.getDarkMutedSwatch();//柔和的暗色
////                    Palette.Swatch mutedLight = palette.getLightMutedSwatch();//柔和的亮色
//                    Palette.Swatch vibrant = palette.getVibrantSwatch();//有活力的
//                    vibrant.getPopulation(); //样本中的像素数量
//                    vibrant.getRgb(); //颜色的RBG值
//                    vibrant.getHsl(); //颜色的HSL值
//                    vibrant.getBodyTextColor(); //主体文字的颜色值
//                    vibrant.getTitleTextColor(); //标题文字的颜色值
//                }
//            }
//        });
//    }

    /**
     * 颜色加深算法
     */
    private int setColorBurn(int rgb, float val) {
        int r = (rgb >> 16) & 0xff;
        int g = (rgb >> 8) & 0xff;
        int b = rgb & 0xff;
        r = (int) Math.floor(r * (1f - val));
        g = (int) Math.floor(g * (1f - val));
        b = (int) Math.floor(b * (1f - val));
        return Color.rgb(r, g, b);
    }

    /**
     * 颜色浅化算法
     */
    private int setColorShallow(int rgb, float val) {
        int r = (rgb >> 16) & 0xff;
        int g = (rgb >> 8) & 0xff;
        int b = rgb & 0xff;
        r = (int) Math.floor(r * (1f + val));
        g = (int) Math.floor(g * (1f + val));
        b = (int) Math.floor(b * (1f + val));
        return Color.rgb(r, g, b);
    }

    //这个就是一个从imageview中获取bitmap的方法
    private Bitmap getBitmap(ImageView imageView) {
        return ((BitmapDrawable) imageView.getDrawable()).getBitmap();
    }
}