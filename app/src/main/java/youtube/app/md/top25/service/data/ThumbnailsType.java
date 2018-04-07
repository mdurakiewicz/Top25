package youtube.app.md.top25.service.data;

/**
 * Created by Marcin on 04.04.2018.
 */

public class ThumbnailsType {

    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ThumbnailsType{" +
                "url='" + url + '\'' +
                '}';
    }
}
