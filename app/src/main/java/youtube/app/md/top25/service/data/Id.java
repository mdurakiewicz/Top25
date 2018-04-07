package youtube.app.md.top25.service.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Marcin on 06.04.2018.
 */

public class Id {

    @SerializedName("videoId")
    String videoId;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "Id{" +
                "videoId='" + videoId + '\'' +
                '}';
    }
}
