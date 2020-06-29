public class StartActivity implements Activity{
    ConsoleWriter cw = new ConsoleWriter();

    public StartActivity(ConsoleWriter Cw) {
        cw = Cw;
    }

    @Override
    public void activity() {
        cw.write("The song is started");
    }
}
