import java.util.List;

public abstract class Cd {
    private int limit;
    private List<Song> songs;

    public int getLimit() {
        return limit;
    }

    public List<Song> getTracks() {
        return songs;
    }
    public abstract void addTrack(Song song);
}
