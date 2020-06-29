import java.util.Scanner;

public class Player {
    public void next(){

    }
    public void prev(){

    }
    public void show(){
        System.out.println("Welcome to our music player");
        Scanner sc = new Scanner(System.in);
        String back = "";
        while (back != "b"){
            String command = sc.next();
            switch (command){
                case "start":
                    start();
                    break;
                case "stop":
                    stop();
                    break;
                case "next":
                    next();
                    break;
                case "prev":
                    prev();
                    break;
                case "back":
                    Main.main(null);
                    back = "b";
                    break;
                default:
                    System.out.println("anyádot");
                    break;
            }
        }
    }
    public void stop(){

    }
    public void start(){

    }
    public void setWriter(Writer writer){

    }
    public void setCd(Cd cd){

    }
    //public void setMode(PlayerMode pm){
    // PlayerMode is an enum
    //}
}
