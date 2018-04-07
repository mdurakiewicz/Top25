package youtube.app.md.top25.service.data;

import java.util.List;

/**
 * Created by Marcin on 04.04.2018.
 */

public class VideosData {

    List<VideoData> items;

    public List<VideoData> getItems() {
        return items;
    }

    public void setItems(List<VideoData> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "VideosData{" +
                "items=" + items +
                '}';
    }
}
