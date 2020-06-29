public class StopActivity implements Activity{
    ConsoleWriter cw = new ConsoleWriter();

    public StopActivity(ConsoleWriter Cw) {
        cw = Cw;
    }

    @Override
    public void activity() {
        cw.write("The song is stopped");
    }
}