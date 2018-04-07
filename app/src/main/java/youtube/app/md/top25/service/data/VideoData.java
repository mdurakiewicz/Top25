package youtube.app.md.top25.service.data;

/**
 * Created by Marcin on 04.04.2018.
 */

public class VideoData {

    Snippet snippet;
    Id id;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    @Override
    public String toString() {
        return "VideoData{" +
                "snippet=" + snippet +
                ", id=" + id +
                '}';
    }
}
