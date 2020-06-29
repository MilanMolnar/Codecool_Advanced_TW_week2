import java.util.List;

public abstract class Cd {

    private int limit;
    private List<Song> songs;
    private String title;

    public Cd(int limit, List<Song> songs, String title) throws Exception {
        if (limit <= 82) {
            this.limit = limit;
        } else {
            throw new Exception("Error, CD limit reached. It must be under 83min!");
        }
        this.title = title;
        this.songs = songs;
    }

    public int getLimit() {

        return limit;
    }

    public String getTitle() {

        return title;
    }

    public List<Song> getTracks() {

        return songs;
    }
    public abstract void addTrack(Song song);
}
