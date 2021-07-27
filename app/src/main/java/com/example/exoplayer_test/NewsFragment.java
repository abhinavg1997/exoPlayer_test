package com.example.exoplayer_test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import jp.shts.android.storiesprogressview.StoriesProgressView;

public class NewsFragment extends Fragment implements StoriesProgressView.StoriesListener, View.OnTouchListener {

    View fragmentView;
    private SimpleExoPlayer exoPlayer;
    private Long playbackPosition = 0L;
    private String mp4Url = "https://html5demos.com/assets/dizzy.mp4";
    private PlayerView playerView;
    private boolean playWhenReady = false;
    private int currentWindow = 0;
    private long pressTime = 0L;
    private long limit = 500L;

    private StoriesProgressView storiesProgressView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = (ViewGroup) inflater.inflate(R.layout.viewpager_item, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fragmentView = view;
        initViews();
        super.onViewCreated(view, savedInstanceState);

    }

    private void initViews() {
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public void onNext() {

    }

    @Override
    public void onPrev() {

    }

    @Override
    public void onComplete() {

    }
}
