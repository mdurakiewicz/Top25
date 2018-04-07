package youtube.app.md.top25.view.data.container;

import java.util.ArrayList;
import java.util.List;

import youtube.app.md.top25.view.data.VideoViewData;

/**
 * Created by Marcin on 04.04.2018.
 */

public class DataViewContainer {

    private static List<VideoViewData> videosViewDataList = new ArrayList<>();

    private DataViewContainer(){
    }

    public static List<VideoViewData> getVideosViewDataList() {
        return videosViewDataList;
    }

    public static void setVideosViewDataList(List<VideoViewData> videosViewDataList) {
        DataViewContainer.videosViewDataList = videosViewDataList;
    }
}
