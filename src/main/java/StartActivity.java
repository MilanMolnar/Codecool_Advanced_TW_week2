public class StartActivity implements Activity{
    ConsoleWriter cw;
    LogWriter log = new LogWriter();

    public StartActivity(ConsoleWriter Cw) {
        cw = Cw;
    }

    @Override
    public void activity(Boolean bool) {
        cw.write("The song is started");
        if(bool){
            log.write("The song is started");
        }
    }
}
