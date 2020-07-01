import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
//Separate Java app that uses RMI.
public class SpotifyServer {
    final static String xmlFilePath = "songs.xml";
    public List<SpotifySong> getTrackList() throws IOException, NotBoundException {
        SpotifyService s = (SpotifyService) Naming.lookup("rmi://localhost:5099/Spotify");
        return s.getSongs(xmlFilePath);
    }
}
