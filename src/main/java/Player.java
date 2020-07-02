import java.io.Console;
import java.util.Scanner;

public class Player {
    public ConsoleWriter cw = new ConsoleWriter();
    Cd cd;
    Playermode pm;
    Boolean bool;
    Writer logger;
    String song;
    int currentIndex = 0;



    public Player(Cd cd, Playermode pm, Boolean bool,Writer logger){
        this.cd = cd;
        this.pm = pm;
        this.bool = bool;
        this.logger=logger;
    }

    public Player(Playermode pm, Boolean bool,Writer logger){
        this.pm = pm;
        this.bool = bool;
        this.logger=logger;
    }

    public Player(){}

    public void next(){
        if(currentIndex == cd.getTracks().size()-1){
            System.out.println(cd.getTracks().size());
            currentIndex = 0;
            song = cd.getTracks().get(currentIndex).getTitle();
        }else
        {
            currentIndex = currentIndex +1;
            song = cd.getTracks().get(currentIndex).getTitle();
        }
        if(Playermode.CD == pm){
            NextActivity next = new NextActivity(cw,song);
            next.activity(bool);
        }else{
            NextActivity next = new NextActivity(cw);
            next.activity(bool);
        }
    }
    public void prev(){
        String song;
        if(currentIndex==0){
            currentIndex = cd.getTracks().size()-1;
            song = cd.getTracks().get(currentIndex).getTitle();
        }else
        {
            currentIndex = currentIndex +1;
            song = cd.getTracks().get(currentIndex).getTitle();
        }
        if(Playermode.CD == pm){
            PrevActivity prev = new PrevActivity(cw,song);
            prev.activity(bool);
        }else{
            PrevActivity prev = new PrevActivity(cw);
            prev.activity(bool);
        }

    }
    public void show(){
        cw.write("Welcome to our music player");
        Scanner sc = new Scanner(System.in);
        String back = "";
        cw.write("Commands\nstart,stop,next,prev,back");
        while (true){
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
                    if (Playermode.SPOTIFY == pm){
                        setCd(cd);
                    }
                    break;
                case "back":
                    //Main.main(null);
                    //back = "b";
                    return;
                default:
                    cw.write("Invalid input");
                    break;
            }
        }
    }
    public void stop(){
        StopActivity stop = new StopActivity(cw);
        stop.activity(bool);
    }
    public void start(){
        String song;
        if(Playermode.CD == pm){
            song = cd.getTracks().get(currentIndex).getTitle();
            StartActivity start = new StartActivity(cw,song);
            start.activity(bool);
        }else{
            StartActivity start = new StartActivity(cw);
            start.activity(bool);
        }


    }
    public void setWriter(Writer logger){
        SetWriterActivity setWriter = new SetWriterActivity(cw,logger);
        setWriter.activity(bool);
    }
    public void setCd(Cd cd){
        SetCdActivity setCd = new SetCdActivity(cw,cd);
        setCd.activity(bool);
    }
    public void setMode(Playermode pm){
        SetModeActivity setModeActivity = new SetModeActivity(cw,pm);
        setModeActivity.activity(bool);
    }
}
