public class StopActivity implements Activity{
    ConsoleWriter cw = new ConsoleWriter();
    LogWriter log = new LogWriter();

    public StopActivity(ConsoleWriter Cw) {
        cw = Cw;
    }

    @Override
    public void activity(Boolean bool) {
        cw.write("The song is stopped");
        if(bool){
            log.write("The song is stopped");
        }
    }
}