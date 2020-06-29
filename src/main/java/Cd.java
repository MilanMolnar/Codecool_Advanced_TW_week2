import java.util.List;

public abstract class Cd {

    private int limit;
    private List<Song> songs;
    private String title;

    public Cd(int limit, List<Song> songs, String title){
        this.limit = limit;
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
