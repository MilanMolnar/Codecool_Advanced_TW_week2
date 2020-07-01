public class NextActivity implements Activity {
    ConsoleWriter cw = new ConsoleWriter();
    LogWriter log = new LogWriter();


    public NextActivity(ConsoleWriter Cw) {
        cw = Cw;
    }

    @Override
    public void activity(Boolean bool) {
        cw.write("The next song is coming");
        if(bool){
            log.write("The next song is coming");
        }
    }
}
