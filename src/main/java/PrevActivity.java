public class PrevActivity implements Activity {
    ConsoleWriter cw = new ConsoleWriter();
    LogWriter log = new LogWriter();
    String song;
    public PrevActivity(ConsoleWriter Cw, String song) {
        cw = Cw;
        this.song = song;
    }

    @Override
    public void activity(Boolean bool) {

        cw.write("The prev "+ song +"is coming");
        if(bool){
            log.write("The prev "+ song + "is coming");
        }
    }
}
