import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.stream.Collectors;

public class Client {
    final static String xmlFilePath = "songs.xml";


    public static void main(String[] args) throws IOException, NotBoundException, ParserConfigurationException, SAXException {
        SpotifyService s = (SpotifyService) Naming.lookup("rmi://localhost:5099/Spotify");
        System.out.println(s.getSongs(xmlFilePath).get(1).getTitle());
    }
}