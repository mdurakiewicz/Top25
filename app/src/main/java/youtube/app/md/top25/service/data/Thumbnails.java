package youtube.app.md.top25.service.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Marcin on 04.04.2018.
 */

public class Thumbnails {

    @SerializedName("default")
    ThumbnailsType defaultType;

    public ThumbnailsType getDefaultType() {
        return defaultType;
    }

    public void setDefaultType(ThumbnailsType defaultType) {
        this.defaultType = defaultType;
    }

    @Override
    public String toString() {
        return "Thumbnails{" +
                "defaultType=" + defaultType +
                '}';
    }
}
