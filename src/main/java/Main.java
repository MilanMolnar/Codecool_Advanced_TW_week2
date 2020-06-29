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


        menu.addItem(playerOption);
        menu.addItem(addCdOption);
        menu.addItem(addSongOption);

        Scanner scanner = new Scanner(System.in);// Create a Scanner object

        while(true){
            try{
                menu.show();

                System.out.println("Please enter an option number: ");
                String userOption = scanner.nextLine();  // Read user input

                switch (userOption){
                    case "1":{
                        // ki kell listazni a cd-ket es meg kell kerdezni, hogy melyik cd-t akarja
                        Player player = new Player();
                        player.show();
                    } case "2":{
                        System.out.println("What kind of CD do you want to add? AudioCD or MP3CD?");
                        userOption = scanner.nextLine();
                        if (userOption.equals("AudioCD")){
                            if (songList.size() == 0){
                                throw new Exception("You have no songs. Please add a song first!");
                            } else {
                                 //AudioCd audioCd = new AudioCd();
                            }
                        } else if(userOption.equals("MP3CD")){
                            if (songList.size() == 0){
                                throw new Exception("You have no songs. Please add a song first!");
                            } else {
                                //  Mp3Cd mp3Cd = new Mp3Cd();
                            }
                        } else{
                            System.out.println("Error!\n");
                        }
                    } case "3":{
                        System.out.println("What kind of song do you want to add? AudioSong or MP3Song?");
                        userOption = scanner.nextLine();
                        if (userOption.equals("AudioSong")){
                            //AudioSong audioSong = new AudioSong();
                        } else if(userOption.equals("MP3Song")){
                            //Mp3Song mp3Song= new Mp3Song();
                        } else{
                            System.out.println("Error!\n");
                        }
                    } default:{
                        System.out.println("Wrong option!\n");
                    }
                }
            } catch (Exception ex){
                System.out.println("You have no songs! Please add a song first.");
                continue;
            }
        }
    }
}
