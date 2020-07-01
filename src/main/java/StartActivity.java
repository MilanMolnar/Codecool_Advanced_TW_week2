public class StartActivity implements Activity{
    ConsoleWriter cw = new ConsoleWriter();
    LogWriter log = new LogWriter();
    String song;

    public StartActivity(ConsoleWriter Cw,String song) {
        cw = Cw;
        this.song = song;
    }
    public StartActivity(ConsoleWriter Cw) {
        cw = Cw;
    }

    @Override
    public void activity(Boolean bool) {
        if(song.isEmpty()){
            cw.write("The " + song + "is started");
            if(bool){
                log.write("The " + song + "is started");
            }
        }else {
            cw.write("The song is started");
            if(bool){
                log.write("The song is started");
            }
        }

    }
}
