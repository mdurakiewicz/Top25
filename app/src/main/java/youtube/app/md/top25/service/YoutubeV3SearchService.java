package youtube.app.md.top25.service;

import retrofit2.http.GET;
import rx.Observable;
import youtube.app.md.top25.service.data.VideosData;

/**
 * Created by Marcin on 04.04.2018.
 */

public interface YoutubeV3SearchService {

    @GET("search?part=snippet&key=AIzaSyA0sVTQEVe8nHrfvhTFBQWMdLQ09BCn4oo&order=viewCount&type=video&maxResults=25")
    Observable<VideosData> getVideos();
}
