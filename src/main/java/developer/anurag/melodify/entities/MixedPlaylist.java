package developer.anurag.melodify.entities;

import org.springframework.data.annotation.Id;

import java.util.List;

public class MixedPlaylist {
    @Id
    private String id;
    private String title;
    private List<String> trackIds,artists,posterUris;

    public MixedPlaylist() {}

    public MixedPlaylist(String id, String title, List<String> trackIds, List<String> artists, List<String> posterUris) {
        this.id = id;
        this.title = title;
        this.trackIds = trackIds;
        this.artists = artists;
        this.posterUris = posterUris;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getPosterUris() {
        return posterUris;
    }

    public void setPosterUris(List<String> posterUris) {
        this.posterUris = posterUris;
    }

    public List<String> getTrackIds() {
        return trackIds;
    }

    public void setTrackIds(List<String> trackIds) {
        this.trackIds = trackIds;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

}
