public class NextActivity implements Activity {
    ConsoleWriter cw = new ConsoleWriter();
    LogWriter log = new LogWriter();
    String song;


    public NextActivity(ConsoleWriter Cw,String song) {
        cw = Cw;
        this.song = song;
    }

    @Override
    public void activity(Boolean bool) {
        if(!song.equals("")) {
            cw.write("The next " + song + "is coming");
            if (bool) {
                log.write("The next " + song + "is coming");
            }
        }else{
            cw.write("The next song is coming");
            if (bool) {
                log.write("The next song is coming");
            }
        }
    }
}
