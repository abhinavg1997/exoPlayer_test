package com.example.exoplayer_test;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<PagerViewHolder> {

    private ArrayList<NewsModel> newsList;
    private Context context;
     SimpleExoPlayer exoPlayer;
    DataSource.Factory dataSourceFactory;

    @Override
    public void onAttachedToRecyclerView(@NonNull  RecyclerView recyclerView) {
        //setting up Exoplayer
        //creating Data Source Factory
         dataSourceFactory = new DefaultHttpDataSourceFactory(Util.getUserAgent(context,
                context.getApplicationInfo().loadLabel(context.getPackageManager()).toString()));
        // Passing Load Control
        DefaultLoadControl loadControl = new DefaultLoadControl.Builder()
                .setBufferDurationsMs(25000,50000,1500,2000)
                .build();
        @DefaultRenderersFactory.ExtensionRendererMode int extensionRendererMode = DefaultRenderersFactory.EXTENSION_RENDERER_MODE_PREFER;
        DefaultRenderersFactory renderersFactory = new DefaultRenderersFactory(context).setExtensionRendererMode(extensionRendererMode);
//        exoPlayer = new SimpleExoPlayer.Builder(context,renderersFactory).setLoadControl(loadControl).build();
            exoPlayer = new SimpleExoPlayer.Builder(context).build();
        super.onAttachedToRecyclerView(recyclerView);
    }

    public ViewPagerAdapter(ArrayList<NewsModel> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @Override
    public void onViewRecycled(@NonNull PagerViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @NonNull
    @Override
    public PagerViewHolder onCreateViewHolder(@NonNull ViewGroup container, int viewType) {
        LayoutInflater mLayoutInflater = LayoutInflater.from(container.getContext());
        View itemView = mLayoutInflater.inflate(R.layout.viewpager_item, container, false);
        PagerViewHolder viewHolder = new PagerViewHolder(itemView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PagerViewHolder holder, int position) {
       MediaItem mediaItem = MediaItem.fromUri(Uri.parse(newsList.get(position).getUrl()));
        MediaSource videoSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(mediaItem);

        exoPlayer.setMediaSource(videoSource);
        exoPlayer.prepare();
        holder.playerView.setPlayer(exoPlayer);
        exoPlayer.setRepeatMode(Player.REPEAT_MODE_ONE);
        holder.playerView.setUseController(true);
//        holder.playerView.hideController();
        holder.playerView.setShowBuffering(PlayerView.SHOW_BUFFERING_WHEN_PLAYING);

        holder.news_head.setText(newsList.get(position).getHeader());
        holder.news_body.setText(newsList.get(position).getBody());


    }

        public void startPlayer() {
        exoPlayer.setPlayWhenReady(true);
        exoPlayer.getPlaybackState();
    }

    public void pausePlayer() {
        exoPlayer.setPlayWhenReady(false);
        exoPlayer.getPlaybackState();
    }

    public void releasePlayer() {
        exoPlayer.setPlayWhenReady(false);
        exoPlayer.release();
        exoPlayer.stop(true);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
