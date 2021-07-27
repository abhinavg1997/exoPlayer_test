package com.example.exoplayer_test;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;

import jp.shts.android.storiesprogressview.StoriesProgressView;

public class PagerViewHolder extends RecyclerView.ViewHolder {

     SimpleExoPlayer exoPlayer;
     Long playbackPosition = 0L;
     PlayerView playerView;
     boolean playWhenReady = false;
     int currentWindow = 0;
     long pressTime = 0L;
     long limit = 500L;
     TextView news_head, news_body;
     ImageButton shareButton;
     StoriesProgressView storiesProgressView;
     MediaSource mediaSource;

    public PagerViewHolder(@NonNull View itemView) {
        super(itemView);
        playerView = itemView.findViewById(R.id.player);
        storiesProgressView = itemView.findViewById(R.id.top_bar);
        news_head = itemView.findViewById(R.id.news_heading);
        news_body = itemView.findViewById(R.id.news_body);
        shareButton = itemView.findViewById(R.id.imgbtn_share);


    }

}
