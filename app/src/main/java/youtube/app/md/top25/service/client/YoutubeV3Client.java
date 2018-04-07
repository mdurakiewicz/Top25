package youtube.app.md.top25.service.client;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import youtube.app.md.top25.service.YoutubeV3SearchService;
import youtube.app.md.top25.service.data.VideosData;

/**
 * Created by Marcin on 04.04.2018.
 */

public class YoutubeV3Client {

    private static final String GOOGLEAPIS_YOUTUBE_V3_BASE_URL = "https://www.googleapis.com/youtube/v3/";
    private static YoutubeV3Client  instance;
    private YoutubeV3SearchService youtubeV3SearchService;

    private YoutubeV3Client() {
        final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(GOOGLEAPIS_YOUTUBE_V3_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        youtubeV3SearchService = retrofit.create(YoutubeV3SearchService.class);
    }

    public static YoutubeV3Client getInstance() {
        if (instance == null) {
            instance = new YoutubeV3Client();
        }
        return instance;
    }


    public Observable<VideosData> getVideos() {
        return youtubeV3SearchService.getVideos();
    }
}
