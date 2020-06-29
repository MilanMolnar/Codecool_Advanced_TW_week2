import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        List<Song> songList = new ArrayList<Song>();
        List<Cd> cdList = new ArrayList<Cd>();

        Menu menu = new Menu();

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

        menu.addItem(playerOption);
        menu.addItem(addCdOption);
        menu.addItem(addSongOption);
        menu.addItem(listCDsOption);
        menu.addItem(listSongsOption);

        Scanner scanner = new Scanner(System.in);// Create a Scanner object

        while(true){
            try{
                menu.show();
                System.out.println("Please enter an option number: ");
                String userOption = scanner.nextLine();  // Read user input

                switch (userOption){
                    case "1":{
                        if (cdList.size() == 0){
                            System.out.println("You have no CDs yet! Please add a CD first!");
                        } else {
                            System.out.println("Your CDs: \n");

                            int counter = 0;
                            for (Cd cd:
                                 cdList) {
                                System.out.println(counter + ") " + cd.getTitle() + "\n" );
                            }

                            System.out.println("Please enter a CD name: ");
                            String cdName = scanner.nextLine();

                            Player player = new Player();
                            for (Cd cd:
                                    cdList) {
                                if (cd.getTitle().equals(cdName)){
                                    player = new Player(cd);
                                }
                            }
                            player.show();
                        }
                    } case "2":{
                        System.out.println("What kind of CD do you want to add? AudioCD or MP3CD?");
                        userOption = scanner.nextLine();
                        if (userOption.equals("AudioCD")){
                            if (songList.size() == 0){
                                throw new Exception("You have no songs. Please add a song first!");
                            } else {
                                System.out.println("Enter the name of the CD: ");
                                String cdName = scanner.nextLine();

                                System.out.println("Enter the limit of the CD: ");
                                int cdLimit = scanner.nextInt();

                                System.out.println("Please choose the songs you want to add to this CD(separate them with comma): ");
                                for (Song song:
                                     songList) {
                                    System.out.println( song.getTitle() + "\n");
                                }
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
                                    AudioCd audioCd = new AudioCd(cdLimit,finalSongs,cdName);
                                    cdList.add(audioCd);
                                } else {
                                    System.out.println("Limit was not enough!");
                                }

                            }
                        } else if(userOption.equals("MP3CD")){
                            if (songList.size() == 0){
                                throw new Exception("You have no songs. Please add a song first!");
                            } else {
                                System.out.println("Enter the name of the CD: ");
                                String cdName = scanner.nextLine();

                                System.out.println("Enter the limit of the CD: ");
                                int cdLimit = scanner.nextInt();

                                for (Song song:
                                        songList) {
                                    System.out.println( song.getTitle() + "\n");
                                }
                                System.out.println("Please choose the songs you want to add to this CD(separate them with comma): ");

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
                                } else {
                                    System.out.println("Limit was not enough!");
                                }
                            }
                        } else{
                            System.out.println("Error!\n");
                        }
                    } case "3":{
                        System.out.println("What kind of song do you want to add? AudioSong or MP3Song?");
                        userOption = scanner.nextLine();
                        if (userOption.equals("AudioSong")){
                            System.out.println("Enter the name of the song: ");
                            String songName = scanner.nextLine();

                            System.out.println("Enter the length of the song: ");
                            int length = scanner.nextInt();

                            AudioSong audioSong = new AudioSong(songName,length);
                            songList.add(audioSong);
                        } else if(userOption.equals("MP3Song")){
                            System.out.println("Enter the name of the song: ");
                            String songName = scanner.nextLine();

                            System.out.println("Enter the length of the song: ");
                            int length = scanner.nextInt();

                            Mp3Song mp3Song = new Mp3Song(songName,length);
                            songList.add(mp3Song);
                        } else{
                            System.out.println("Error!\n");
                        }
                    } case "4":{
                        for (Cd cd:
                             cdList) {
                            System.out.println("\nCD name: " + cd.getTitle() + " CD limit: " + cd.getLimit()+ "\n");
                        }
                    } case "5":{
                        for (Song song:
                                songList) {
                            System.out.println("\nSong name: " + song.getTitle() + " Song length: " + song.getLength() + "min.\n");
                        }
                    }
                }
            } catch (Exception ex){
                System.out.println("You have no songs! Please add a song first.");
                continue;
            }
        }
    }
}
