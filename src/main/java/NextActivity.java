public class NextActivity implements Activity {
    ConsoleWriter cw = new ConsoleWriter();

    public NextActivity(ConsoleWriter Cw) {
        cw = Cw;
    }

    @Override
    public void activity() {
        cw.write("The next song is coming");
    }
}
