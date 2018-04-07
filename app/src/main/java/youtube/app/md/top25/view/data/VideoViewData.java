package youtube.app.md.top25.view.data;

/**
 * Created by Marcin on 04.04.2018.
 */

public class VideoViewData {

    String title;
    String channelTitle;
    String imgUrl;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    String videoId;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "VideoViewData{" +
                "title='" + title + '\'' +
                ", channelTitle='" + channelTitle + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", videoId='" + videoId + '\'' +
                '}';
    }
}
