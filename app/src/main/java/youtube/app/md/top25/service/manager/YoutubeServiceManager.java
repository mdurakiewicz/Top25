package youtube.app.md.top25.service.manager;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import youtube.app.md.top25.service.client.YoutubeV3Client;
import youtube.app.md.top25.service.data.VideoData;
import youtube.app.md.top25.service.data.VideosData;
import youtube.app.md.top25.view.adapter.VideosListAdapter;
import youtube.app.md.top25.view.data.VideoViewData;
import youtube.app.md.top25.view.data.container.DataViewContainer;

/**
 * Created by Marcin on 04.04.2018.
 */

public class YoutubeServiceManager {

    private static final String TAG = YoutubeServiceManager.class.getSimpleName();

    public Subscription getVideosSubscription() {
        return videosSubscription;
    }

    public void setVideosSubscription(Subscription videosSubscription) {
        this.videosSubscription = videosSubscription;
    }

    private Subscription videosSubscription;

    public void getVideos(final VideosListAdapter videosListAdapter){

        videosSubscription = YoutubeV3Client.getInstance()
                .getVideos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideosData>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "In onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "In onError()");
                    }

                    @Override
                    public void onNext(VideosData videosData) {

                        Log.d(TAG, videosData.toString());

                        List<VideoViewData> videoViewDataList = new ArrayList<>();

                        for(VideoData videoData : videosData.getItems()){
                            VideoViewData videoViewData = new VideoViewData();
                            if(videoData != null && videoData.getSnippet() != null) videoViewData.setTitle(videoData.getSnippet().getTitle());
                            if(videoData != null && videoData.getSnippet() != null) videoViewData.setChannelTitle(videoData.getSnippet().getChannelTitle());
                            if(videoData != null && videoData.getSnippet() != null && videoData.getSnippet().getThumbnails() != null && videoData.getSnippet().getThumbnails().getDefaultType() != null) videoViewData.setImgUrl(videoData.getSnippet().getThumbnails().getDefaultType().getUrl());
                            if(videoData != null && videoData.getId() != null) videoViewData.setVideoId(videoData.getId().getVideoId());
                            videoViewDataList.add(videoViewData);
                        }

                        DataViewContainer.setVideosViewDataList(videoViewDataList);

                        videosListAdapter.setVideoViewDataList(videoViewDataList);
                    }
                });

    }
}
