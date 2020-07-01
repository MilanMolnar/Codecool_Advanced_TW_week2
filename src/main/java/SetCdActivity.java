public class SetCdActivity implements Activity {
    Cd cd;
    ConsoleWriter cw;
    LogWriter log = new LogWriter();

    public SetCdActivity(ConsoleWriter Cw, Cd cd) {
        cw = Cw;
        this.cd = cd;
    }

    @Override
    public void activity(Boolean bool) {

        cw.write("The cd is changed to" + cd.getTitle());
        if(bool){
            log.write("The cd is changed to" + cd.getTitle());
        }
    }
}