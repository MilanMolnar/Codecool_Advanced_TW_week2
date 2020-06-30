public class SetModeActivity implements Activity {
    ConsoleWriter cw = new ConsoleWriter();
    Playermode pm;
    LogWriter log = new LogWriter();


    public SetModeActivity(ConsoleWriter Cw,Playermode pm) {
        cw = Cw;
        this.pm = pm;
    }

    @Override
    public void activity(Boolean bool) {
        if(pm == Playermode.CD){
            cw.write("The Playermode is changed to CD");
            if(bool){
                log.write("The Playermode is changed to CD");
            }
        }
        else if(pm == Playermode.SPOTIFY){
            cw.write("The Playermode is changed to Spotify");
            if(bool){
                log.write("The Playermode is changed to Spotify");
            }
        }
    }
}