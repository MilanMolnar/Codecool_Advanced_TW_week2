public class StartActivity implements Activity{
    ConsoleWriter cw = new ConsoleWriter();
    LogWriter log = new LogWriter();
    String song;

    public StartActivity(ConsoleWriter Cw,String song) {
        cw = Cw;
        this.song = song;
    }

    @Override
    public void activity(Boolean bool) {
        cw.write("The " + song + "is started");
        if(bool){
            log.write("The " + song + "is started");
        }
    }
}
