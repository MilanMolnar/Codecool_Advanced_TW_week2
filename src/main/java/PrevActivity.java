public class PrevActivity implements Activity {
    ConsoleWriter cw = new ConsoleWriter();
    LogWriter log = new LogWriter();
    String song;
    public PrevActivity(ConsoleWriter Cw, String song) {
        cw = Cw;
        this.song = song;
    }

    public PrevActivity(ConsoleWriter Cw) {
        cw = Cw;
    }

    @Override
    public void activity(Boolean bool) {
        if(song.isEmpty()) {
            cw.write("The prev " + song + "is coming");
            if (bool) {
                log.write("The prev " + song + "is coming");
            }
        }else{
            cw.write("The prev song is coming");
            if (bool) {
                log.write("The prev song is coming");
            }
        }
    }
}
