package com.shinfo.youtubevideoplayerapp;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;
public class CustomListAdapter extends BaseAdapter {
    Activity activity;
    String API_KEY="AIzaSyANL5OU0dh0fQSlCh42cmyROeOGj5y7GFg";
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    private LayoutInflater inflater;
    ArrayList<VideoDetails> singletons;
    public CustomListAdapter(Activity activity, ArrayList<VideoDetails> singletons) {
        this.activity = activity;
        this.singletons = singletons;
    }
    public int getCount() {
        return this.singletons.size();
    }
    public Object getItem(int i) {
        return this.singletons.get(i);
    }
    public long getItemId(int i) {
        return (long) i;
    }
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        if (this.inflater == null) {
            this.inflater = (LayoutInflater) this.activity.getLayoutInflater();
                   // getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.videolist, null);
        }
        if (this.imageLoader == null) {
            this.imageLoader = AppController.getInstance().getImageLoader();
        }
        final NetworkImageView networkImageView = (NetworkImageView) convertView.findViewById(R.id.video_image);
        final TextView imgtitle = (TextView) convertView.findViewById(R.id.video_title);
        final TextView imgdesc = (TextView) convertView.findViewById(R.id.video_description);
        //final TextView tvURL=(TextView)convertView.findViewById(R.id.tv_url);
        final  TextView tvVideoID=(TextView)convertView.findViewById(R.id.video_Id);
//       ((LinearLayout) convertView.findViewById(R.id.asser)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(view.getContext(), VideoActivity.class);
//                intent.putExtra("videoId",tvVideoID.getText().toString());
//                view.getContext().startActivity(intent);
//            }
//        });
        final VideoDetails singleton = (VideoDetails) this.singletons.get(i);
        networkImageView.setImageUrl(singleton.getURL(), this.imageLoader);
       // tvVideoID.setText(singleton.getVideoId());
        imgtitle.setText(singleton.getVideoName());
        imgdesc.setText(singleton.getVideoDesc());
//networkImageView.initialize(API_KEY,new YouTubeThumbnailView.OnInitializedListener(){
//
//    @Override
//    public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
//      youTubeThumbnailLoader.setVideo(singleton.getVideoId());
//      youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
//          @Override
//          public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
//              youTubeThumbnailLoader.release();
//          }
//
//          @Override
//          public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {
//
//          }
//      });
//    }
//
//    @Override
//    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
//
//    }
//});
        return convertView;
    }
}