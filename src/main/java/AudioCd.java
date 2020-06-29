import javax.swing.plaf.ActionMapUIResource;
import java.util.List;

public class AudioCd extends Cd{

    public AudioCd(int limit, List<Song> songs, String title) throws Exception {
        super(limit, songs,title);
    }
    @Override
    public void addTrack(Song song) {
        List<Song> songs = super.getTracks();
        songs.add(song);
    }
}
