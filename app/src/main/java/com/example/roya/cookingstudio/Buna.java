package com.example.roya.cookingstudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class Buna extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener
{

    public static final String API_KEY = "AIzaSyCd_hXYZ6GArgYYNbgSYDodmH-P-sUfYFg";
    public static final String VIDEO_ID = "6M26DGsYTsI";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buna);

        /** Initializing YouTube Player View **/
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_buna);
        youTubePlayerView.initialize(API_KEY, this);

    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult result)
    {
        Toast.makeText(this, "Failed to Initialize!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored)
    {

        /** add listeners to YouTubePlayer instance **/
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);

        /** Start buffering **/
        if (!wasRestored)
        {
            player.cueVideo(VIDEO_ID);
        }
    }
    private PlaybackEventListener playbackEventListener = new PlaybackEventListener()
    {
        @Override
        public void onBuffering(boolean arg0) {
        }
        @Override
        public void onPaused() {
        }
        @Override
        public void onPlaying() {
        }
        @Override
        public void onSeekTo(int arg0) {
        }
        @Override
        public void onStopped() {
        }
    };

    private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener()
    {
        @Override
        public void onAdStarted() {
        }
        @Override
        public void onError(ErrorReason arg0) {
        }
        @Override
        public void onLoaded(String arg0) {
        }
        @Override
        public void onLoading() {
        }
        @Override
        public void onVideoEnded() {
        }
        @Override
        public void onVideoStarted() {
        }
    };
}
