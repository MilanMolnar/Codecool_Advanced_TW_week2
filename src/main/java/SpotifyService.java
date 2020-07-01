
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SpotifyService extends Remote {
    public String echo(String input) throws RemoteException;
    public List<SpotifySong> getSongs(String xml) throws IOException;
}