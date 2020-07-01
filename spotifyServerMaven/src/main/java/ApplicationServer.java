
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ApplicationServer {

    public static void main(String[] args) throws RemoteException {
        // write your code here
        Registry registry = LocateRegistry.createRegistry(5099);
        registry.rebind("Spotify", new SpotifyServant());
    }
}