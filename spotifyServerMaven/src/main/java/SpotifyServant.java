

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class SpotifyServant extends UnicastRemoteObject implements SpotifyService {

    public SpotifyServant() throws RemoteException {
        super();
    }

    @Override
    public String echo(String input) throws RemoteException {
        return "szerver: " + input;
    }

    @Override
    public List<SpotifySong> getSongs(String xml) throws IOException, ParserConfigurationException, SAXException {
        //xml to json string

            return deserializeFromXML(xml);

    }

    public List<SpotifySong> deserializeFromXML(String xml) throws ParserConfigurationException, IOException, SAXException {
        List<SpotifySong> songs = new ArrayList<>();

        File xmlFile = new File("songs.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("song");

        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);


            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                String uid = elem.getAttribute("id");

                Node node1 = elem.getElementsByTagName("title").item(0);
                String fname = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("length").item(0);
                String lname = node2.getTextContent();

                SpotifySong song = new SpotifySong();
                song.setTitle(fname);
                song.setLength(Integer.parseInt(lname));
                songs.add(song);

            }
        }
        return songs;
    }
}
