import java.util.List;

public class Mp3Cd extends Cd {
    public Mp3Cd(int limit, List<Song> songs) throws Exception {
        super(limit, songs);
    }

    @Override
    public void addTrack(Song song) {
        List<Song> songs = super.getTracks();
        songs.add(song);
    }
}
