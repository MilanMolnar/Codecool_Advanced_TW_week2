public class PrevActivity implements Activity {
    ConsoleWriter cw = new ConsoleWriter();

    public PrevActivity(ConsoleWriter Cw) {
        cw = Cw;
    }

    @Override
    public void activity() {

        cw.write("The prev song is coming");
    }
}
