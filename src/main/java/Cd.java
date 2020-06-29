import java.util.List;

public abstract class Cd {

    private int limit;
    private List<Song> songs;
    private String title;

    public Cd(int limit, List<Song> songs, String title) throws Exception {
        if (limit <= 700) {
            this.limit = limit;
        } else {
            throw new Exception("Error, CD limit reached. It must be 800MB!");
        }
        this.title = title;
        this.songs = songs;
    }

    public int getLimit() {

        return limit;
    }

    public List<Song> getTracks() {

        return songs;
    }
    public abstract void addTrack(Song song);
}
