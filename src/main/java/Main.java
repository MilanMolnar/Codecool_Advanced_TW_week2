import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static ConsoleWriter cw = new ConsoleWriter();

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean askForLog(Scanner scanner){
        while (true){
            cw.write("\nDo you want to log the input? [yes/no]: \n");
            String userOption = scanner.nextLine();
            if (userOption.toLowerCase().equals("yes")){
                return true;
            } else if(userOption.toLowerCase().equals("no")){
                return false;
            } else{
                cw.write("\nWrong answer :c");
                continue;
            }
        }
    }

    public static void addOptions(Menu menu){
        MenuItem playerOption = new MenuItem();
        playerOption.setTitle("1 Player with an existing CD (if you have CDs)");

        MenuItem addCdOption = new MenuItem();
        addCdOption.setTitle("2 Add a new CD (if you have songs)");

        MenuItem addSongOption = new MenuItem();
        addSongOption.setTitle("3 Add a song");

        MenuItem listCDsOption = new MenuItem();
        listCDsOption.setTitle("4 Show my CDs");

        MenuItem listSongsOption = new MenuItem();
        listSongsOption.setTitle("5 Show my songs");

        MenuItem spotifySongsOption = new MenuItem();
        listSongsOption.setTitle("6 Spotify songs");

        menu.addItem(playerOption);
        menu.addItem(addCdOption);
        menu.addItem(addSongOption);
        menu.addItem(listCDsOption);
        menu.addItem(listSongsOption);
        menu.addItem(spotifySongsOption);
    }

    public static void choose(List<Song> songList, List<Cd> cdList, Scanner scanner, BufferedReader br, Boolean logging,LogWriter logger, Date date,SimpleDateFormat formatter, Boolean isSpotify) throws IOException {
        cw.write("Please enter an option number: ");
        String userOption = scanner.nextLine();
        if (userOption.equals("1")){
            if (cdList.size() == 0){
                cw.write("You have no CDs yet! Please add a CD first!");
            } else {
                cw.write("Your CDs: \n");

                int counter = 0;
                for (Cd cd:
                        cdList) {
                    cw.write(counter + ") " + cd.getTitle() + "\n" );
                }

                cw.write("Please enter a CD name: ");
                String cdName = scanner.nextLine();

                Player player = new Player();
                List<String> cdnames = new ArrayList<>();
                for (Cd cd:
                        cdList) {
                    cdnames.add(cd.getTitle());
                    if (cdnames.contains(cdName)){
                        if (cd.getTitle().equals(cdName)){
                            Playermode pm = Playermode.CD;
                            player = new Player(cd,pm,logging,logger);
                            player.show();
                        }
                    } else{
                        cw.write("Invalid name. Please press enter to continue...");
                        br.readLine();
                    }
                }
            }
        } else if(userOption.equals("2")){
            cw.write("What kind of CD do you want to add? AudioCD or MP3CD?");
            userOption = scanner.nextLine();
            if (userOption.equals("AudioCD")){
                if (songList.size() == 0){
                    cw.write(("You have no songs. Please add a song first!"));
                } else {
                    cw.write("Enter the name of the CD: ");
                    String cdName = scanner.nextLine();

                    cw.write("Enter the limit of the CD: ");
                    int cdLimit = scanner.nextInt();

                    for (Song song:
                            songList) {
                        cw.write( song.getTitle() + "\n");
                    }

                    cw.write("\nPlease choose the songs you want to add to this CD(separate them with comma): ");
                    String chosenSongs = scanner.next();

                    String[] songArray = chosenSongs.split(",");
                    List<Song> finalSongs = new ArrayList<Song>();

                    for (int i = 0; i < songList.size(); i++) {
                        if (songList.get(i).getTitle().equals(songArray[i])){
                            finalSongs.add(songList.get(i));
                        }
                    }

                    int limitCounter = 0;
                    for (Song song:
                            finalSongs) {
                        limitCounter += song.getLength();
                    }

                    if (limitCounter <= cdLimit){
                        AudioCd audioCd = new AudioCd(cdLimit,finalSongs,cdName);
                        cdList.add(audioCd);
                        if (logging){
                            logger.write("CD added successfully at " + formatter.format(date));
                        }
                        cw.write("CD added successfully. Please press enter to continue...");
                        br.readLine();
                    } else {
                        cw.write("Limit was not enough!");
                    }
                }
            } else if(userOption.equals("MP3CD")){
                if (songList.size() == 0){
                    cw.write(("You have no songs. Please add a song first!"));
                } else {
                    cw.write("Enter the name of the CD: ");
                    String cdName = scanner.nextLine();

                    cw.write("Enter the limit of the CD: ");
                    int cdLimit = scanner.nextInt();

                    for (Song song:
                            songList) {
                        cw.write( song.getTitle() + "\n");
                    }
                    cw.write("\nPlease choose the songs you want to add to this CD(separate them with comma): ");

                    String chosenSongs = scanner.nextLine();

                    String[] songArray = chosenSongs.split(",");
                    List<Song> finalSongs = new ArrayList<Song>();

                    for (int i = 0; i < songList.size(); i++) {
                        if (songList.get(i).getTitle().equals(songArray[i])){
                            finalSongs.add(songList.get(i));
                        }
                    }

                    int limitCounter = 0;
                    for (Song song:
                            finalSongs) {
                        limitCounter += song.getLength();
                    }

                    if (limitCounter < cdLimit){
                        Mp3Cd mp3cd = new Mp3Cd(cdLimit,finalSongs,cdName);
                        cdList.add(mp3cd);
                        if (logging){
                            logger.write("CD added successfully at " + formatter.format(date));
                        }
                        cw.write("CD added successfully. Please press enter to continue...");
                        br.readLine();
                    } else {
                        cw.write("Limit was not enough!");
                    }
                }
            } else{
                cw.write("Error!\n");
            }
        } else if(userOption.equals("3")){
            cw.write("What kind of song do you want to add? AudioSong or MP3Song?");
            userOption = scanner.nextLine();
            if (userOption.equals("AudioSong")){
                cw.write("Enter the name of the song: ");
                String songName = scanner.nextLine();

                cw.write("Enter the length of the song: ");
                int length = scanner.nextInt();

                AudioSong audioSong = new AudioSong(songName,length);
                songList.add(audioSong);
                if (logging){
                    logger.write("Song added successfully at " + formatter.format(date));
                }
                cw.write("Song added successfully. Please press enter to continue...");
                br.readLine();
            } else if(userOption.equals("MP3Song")){
                cw.write("Enter the name of the song: ");
                String songName = scanner.nextLine();

                cw.write("Enter the length of the song: ");
                int length = scanner.nextInt();

                Mp3Song mp3Song = new Mp3Song(songName,length);
                songList.add(mp3Song);
                if (logging){
                    logger.write("Song added successfully at " + formatter.format(date));
                }
                cw.write("Song added successfully. Please press enter to continue...");
                br.readLine();
            } else{
                cw.write("Error!\n");
            }
        } else if (userOption.equals("4")){
            if (logging){
                logger.write("Asked for cds at " + formatter.format(date));
            }
            if (cdList.size() != 0){
                for (Cd cd:
                        cdList) {
                    cw.write("\nCD name: " + cd.getTitle() + " CD limit: " + cd.getLimit()+ "\n");
                }
                cw.write("\nPlease press enter to continue...");
                br.readLine();
            } else {
                cw.write("\nYou have no CDs. Please press enter to continue...");
                br.readLine();
            }
        } else if (userOption.equals("5")) {
            if (logging){
                logger.write("Asked for songs at " + formatter.format(date));
            }
            if (songList.size() != 0){
                for (Song song :
                        songList) {
                    cw.write("\nSong name: " + song.getTitle() + " Song length: " + song.getLength() + "min.\n");
                }
                cw.write("\nPlease press enter to continue...");
                br.readLine();
            }else {
                cw.write("\nYou have no songs. Please press enter to continue...");
                br.readLine();
            }
        } else if (userOption.equals("6")) {
            SpotifyServer spotify= new SpotifyServer();
            try {
                if (logging){
                    logger.write("Asked for Spotify songs at " + formatter.format(date));
                }
                clearScreen();
                for (SpotifySong song: spotify.getTrackList()) {
                    System.out.println("Spotify song: " + song.getTitle() + " length: " + song.getLength());
                };
                System.out.println("\nPlease press enter to continue...");
                br.readLine();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public static Boolean askForSpotify(Scanner scanner){
        while (true){
            cw.write("\nDo you want to use Spotify service?(yes/no)\n");
            String userOption = scanner.nextLine();
            if (userOption.toLowerCase().equals("yes")){
                return true;
            } else if(userOption.toLowerCase().equals("no")){
                return false;
            } else{
                cw.write("\nWrong answer :c");
                continue;
            }
        }
    }

    public static void main(String[] args){
        List<Song> songList = new ArrayList<Song>();
        List<Cd> cdList = new ArrayList<Cd>();
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LogWriter logger = new LogWriter();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Menu menu = new Menu();


        clearScreen();
        Boolean logging = askForLog(scanner);
        addOptions(menu);

        Boolean isSpotify = askForSpotify(scanner);

        if(isSpotify){
            clearScreen();
            Playermode pm = Playermode.SPOTIFY;
            Player player = new Player(pm,logging,logger);
            player.show();
        }else{
            while(true){
                clearScreen();
                menu.show();
                try{
                    choose(songList,cdList,scanner,br,logging,logger,date,formatter, isSpotify);
                } catch (Exception ec){
                    cw.write("Something went wrong!");
                }
            }
        }
    }
}
