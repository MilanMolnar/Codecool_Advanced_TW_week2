
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SpotifyService extends Remote {
    public String echo(String input) throws RemoteException;
    public String getSongs(String xml) throws IOException;
}