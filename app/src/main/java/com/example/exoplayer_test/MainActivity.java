package com.example.exoplayer_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.exoplayer2.ExoPlayer;
//import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.util.Util;

import java.util.ArrayList;

import jp.shts.android.storiesprogressview.StoriesProgressView;

public class MainActivity extends AppCompatActivity implements StoriesProgressView.StoriesListener, View.OnTouchListener {

//    private SimpleExoPlayer exoPlayer;
//    private Long playbackPosition = 0L;
    private String mp4Url = "https://html5demos.com/assets/dizzy.mp4";

    private boolean playWhenReady = false;
    private int currentWindow = 0;
    private long pressTime = 0L;
    private long limit = 500L;
    private StoriesProgressView storiesProgressView;
    private PlayerView playerView;

    ViewPager2 viewPager2;
    ArrayList<NewsModel> list;
    int pagePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        playerView = findViewById(R.id.player);
//        initializePlayer();
//        storiesProgressView = findViewById(R.id.top_bar);
//        storiesProgressView.setStoriesCount(1);
//        playerView.setOnTouchListener(this);
        pagePosition =0;
        viewPager2 = findViewById(R.id.view_pager);
        list = DummyData.getList();
        ViewPagerAdapter adapter = new ViewPagerAdapter(list, this);
        viewPager2.setAdapter(adapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                if(pagePosition != position) {
//                    pagePosition = position;
//                    adapter.releasePlayer();
//                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Util.SDK_INT >= 24) {
//            initializePlayer();
        }

    }


    @Override
    protected void onStop() {
        super.onStop();
        if (Util.SDK_INT >= 24) {
//            releasePlayer();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (Util.SDK_INT < 24) {
//            releasePlayer();
        }
    }

    private void releasePlayer() {
//        if (exoPlayer != null) {
//            playWhenReady = exoPlayer.getPlayWhenReady();
//            playbackPosition = exoPlayer.getCurrentPosition();
//            currentWindow = exoPlayer.getCurrentWindowIndex();
//            exoPlayer.release();
//            exoPlayer = null;
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        hideSystemUi();
//        if (Util.SDK_INT < 24 || exoPlayer == null) {
//            initializePlayer();
//        }
    }

//    private void initializePlayer() {
//
//        exoPlayer = new SimpleExoPlayer.Builder(this).build();
//        playerView.setPlayer(exoPlayer);
//        MediaItem mediaItem = MediaItem.fromUri(mp4Url);
//        exoPlayer.setMediaItem(mediaItem);
//        exoPlayer.setPlayWhenReady(playWhenReady);
//        exoPlayer.seekTo(currentWindow, playbackPosition);
//        exoPlayer.prepare();
//    }

    @Override
    public void onNext() {

    }

    @Override
    public void onPrev() {

    }

    @Override
    public void onComplete() {

    }

    @SuppressLint("InlinedApi")
    private void hideSystemUi() {
        playerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
//            case R.id.player: {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    pressTime = System.currentTimeMillis();
//                    storiesProgressView.pause();
//                    exoPlayer.pause();
//                    return false;
//                } else if (event.getAction() == MotionEvent.ACTION_UP) {
//                    long now = System.currentTimeMillis();
//                    storiesProgressView.resume();
//                    exoPlayer.play();
//                    return limit < now - pressTime;
//                }
//            }
        }

        return false;
    }
}

