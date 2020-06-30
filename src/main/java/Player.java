import java.io.Console;
import java.util.Scanner;

public class Player {
    public ConsoleWriter cw = new ConsoleWriter();
    Cd cd;
    Playermode pm;

    public Player(Cd cd, Playermode pm){
        this.cd = cd;
        this.pm = pm;
    }

    public Player(){}

    public void next(){
        NextActivity next = new NextActivity(cw);
        next.activity();

    }
    public void prev(){
        PrevActivity prev = new PrevActivity(cw);
        prev.activity();
    }
    public void show(){
        System.out.println("Welcome to our music player");
        Scanner sc = new Scanner(System.in);
        String back = "";
        while (!back.equals("b")){
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
                case "setcd":
                    setCd(cd);
                    break;
                case "back":
                    Main.main(null);
                    back = "b";
                    break;
                default:
                    cw.write("Invalid input");
                    break;
            }
        }
    }
    public void stop(){
        StopActivity stop = new StopActivity(cw);
        stop.activity();
    }
    public void start(){
        StartActivity start = new StartActivity(cw);
        start.activity();
    }
    public void setWriter(Writer writer){

    }
    public void setCd(Cd cd){
        SetCdActivity setCd = new SetCdActivity(cw,cd);
        setCd.activity();
    }
    public void setMode(Playermode pm){
        SetModeActivity setModeActivity = new SetModeActivity(cw,pm);
        setModeActivity.activity();
    }
}
