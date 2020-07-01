import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.stream.Collectors;

public class Client {
    final static String xmlFilePath = "songs.xml";


    public static void main(String[] args) throws IOException, NotBoundException {
        SpotifyService s = (SpotifyService) Naming.lookup("rmi://localhost:5099/Spotify");
        System.out.println(s.echo("ez megy xd"));
        System.out.println(s.getSongs(xmlFilePath));
    }
}