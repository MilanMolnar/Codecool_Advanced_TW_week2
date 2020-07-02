public class StartActivity implements Activity{
    ConsoleWriter cw = new ConsoleWriter();
    LogWriter log = new LogWriter();
    String song = "";

    public StartActivity(ConsoleWriter Cw,String song) {
        cw = Cw;
        this.song = song;
    }
    public StartActivity(ConsoleWriter Cw) {
        cw = Cw;
    }
//rakos the is started spotify geci
    @Override
    public void activity(Boolean bool) {
        if(!song.equals("")){
            cw.write("The " + song + "is started");
            if(bool){
                log.write("The " + song + "is started");
            }
        }else {
            cw.write("The song is started");
            if(bool){
                log.write("The song is started");
            }
        }

    }
}
