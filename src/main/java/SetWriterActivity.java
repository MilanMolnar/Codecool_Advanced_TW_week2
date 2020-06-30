public class SetWriterActivity implements Activity {
    ConsoleWriter cw;
    Writer logger;
    LogWriter log;

    public SetWriterActivity(ConsoleWriter Cw,Writer logger) {
        cw = Cw;
        this.logger = logger;
    }

    @Override
    public void activity(Boolean bool) {
        if(logger instanceof LogWriter){
            cw.write("The writer changed to Logwriter");
            if(bool){
              log.write("The writer changed to Logwriter");
            }
        }
        else if(logger instanceof ConsoleWriter){
            cw.write("The writer changed to Consolewriter");
            if(bool){
                log.write("The writer changed to Consolewriter");
            }
        }
    }
}