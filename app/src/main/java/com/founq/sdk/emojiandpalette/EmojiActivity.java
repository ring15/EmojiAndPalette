package com.founq.sdk.emojiandpalette;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.emoji.bundled.BundledEmojiCompatConfig;
import androidx.emoji.text.EmojiCompat;
import androidx.emoji.widget.EmojiButton;
import androidx.emoji.widget.EmojiEditText;
import androidx.emoji.widget.EmojiTextView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class EmojiActivity extends AppCompatActivity {


    private static final String SMILE = "\uD83D\uDE01";//Beaming Face With Smiling Eyes  U+1F601
    private static final String RAISED_EYE = "\uD83E\uDD28";//Face With Raised Eyebrow U+1F928
    private static final String SUPER_HERO = "\uD83E\uDDB8";//Superhero U+1F9B8

    private static final String EMOJI = SMILE + RAISED_EYE + SUPER_HERO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji);
        EmojiTextView emojiTextView = findViewById(R.id.emojiTextView);//单独提供的可以加载emoji的控件
        emojiTextView.setText(EMOJI);

        EmojiButton emojiButton = findViewById(R.id.emojiButton);
        emojiButton.setText(EMOJI);

        EmojiEditText emojiEditText = findViewById(R.id.emojiEditText);
        emojiEditText.setText(EMOJI);
        TextView textView = findViewById(R.id.tv_show_emoji);
        textView.setText(EMOJI);
//        EmojiCompat.get().registerInitCallback(new InitCallback(textView));//让普通的TextView显示Emoji
    }

//    private static class InitCallback extends EmojiCompat.InitCallback
//    {
//        private final WeakReference<TextView> mRegularTextViewRef;
//
//        InitCallback(TextView regularTextView)
//        {
//            mRegularTextViewRef = new WeakReference<>(regularTextView);
//        }
//
//        @Override
//        public void onInitialized()
//        {
//            final TextView tvNormalUseEmoji = mRegularTextViewRef.get();
//            if (tvNormalUseEmoji != null)
//            {
//                final EmojiCompat compat = EmojiCompat.get();
//                final Context context = tvNormalUseEmoji.getContext();
//                tvNormalUseEmoji.setText(compat.process(EMOJI));
//            }
//        }
//    }

}