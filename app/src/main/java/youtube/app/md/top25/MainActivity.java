package youtube.app.md.top25;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import youtube.app.md.top25.service.manager.YoutubeServiceManager;
import youtube.app.md.top25.view.adapter.VideosListAdapter;
import youtube.app.md.top25.view.data.container.DataViewContainer;

public class MainActivity extends AppCompatActivity {

    private YoutubeServiceManager youtubeServiceManager;
    public static String VIDEO_ID = "videoId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView videosListView = findViewById(R.id.videos);

        videosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, VideoPlayerActivity.class);
                intent.putExtra(VIDEO_ID, DataViewContainer.getVideosViewDataList().get(position).getVideoId());
                startActivity(intent);
            }
        });

        VideosListAdapter videosListAdapter = new VideosListAdapter(getApplicationContext());

        videosListView.setAdapter(videosListAdapter);

        youtubeServiceManager = new YoutubeServiceManager();
        youtubeServiceManager.getVideos(videosListAdapter);

    }

    @Override
    protected void onDestroy() {

        if (youtubeServiceManager.getVideosSubscription()!= null && !youtubeServiceManager.getVideosSubscription().isUnsubscribed()) {
            youtubeServiceManager.getVideosSubscription().unsubscribe();
        }

        super.onDestroy();
    }
}
