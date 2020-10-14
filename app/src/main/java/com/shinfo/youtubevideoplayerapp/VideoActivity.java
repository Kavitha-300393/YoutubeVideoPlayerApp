package com.shinfo.youtubevideoplayerapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Config;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragmentX;
import com.google.android.youtube.player.YouTubePlayerView;
public class VideoActivity extends Fragment {

    String API_KEY="AIzaSyANL5OU0dh0fQSlCh42cmyROeOGj5y7GFg";
    private static final int RECOVERY_REQUEST = 1;
    String TAG="VideoActivity";
    String showVideo="RsNiCj4p3cQ";
    YouTubePlayerSupportFragmentX youTubePlayerSupportFragmentX;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_video,container,false);
       MainActivity activity=(MainActivity)getActivity();
       showVideo=activity.sendData();
       youTubePlayerSupportFragmentX=YouTubePlayerSupportFragmentX.newInstance();
        FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_fragment1,youTubePlayerSupportFragmentX);
        transaction.commit();
//youTubePlayerSupportFragmentX=(YouTubePlayerSupportFragmentX)getActivity().getSupportFragmentManager().findFragmentById(R.id.youtube_fragment1);

youTubePlayerSupportFragmentX.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        Log.e(TAG,"Video" +showVideo);
        youTubePlayer.cueVideo(showVideo);    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(getActivity(), RECOVERY_REQUEST).show();
        } else {
//            Toast.makeText(this, "Error Intializing Youtube Player", Toast.LENGTH_LONG).show();
        }
    }
});
    return view;
    }


}