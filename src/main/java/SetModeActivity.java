public class SetModeActivity implements Activity {
    ConsoleWriter cw = new ConsoleWriter();
    Playermode pm;
    public SetModeActivity(ConsoleWriter Cw,Playermode pm) {
        cw = Cw;
        this.pm = pm;
    }

    @Override
    public void activity() {
        if(pm == Playermode.CD){
            cw.write("The Playermode is changed to CD");
        }
        else if(pm == Playermode.SPOTIFY){
            cw.write("The Playermode is changed to Spotify");
        }
    }
}