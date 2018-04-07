package youtube.app.md.top25.service.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Marcin on 04.04.2018.
 */

public class Snippet {

    String title;
    Thumbnails thumbnails;

    @SerializedName("channelTitle")
    String channelTitle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    @Override
    public String toString() {
        return "Snippet{" +
                "title='" + title + '\'' +
                ", thumbnails=" + thumbnails +
                ", channelTitle='" + channelTitle + '\'' +
                '}';
    }
}
