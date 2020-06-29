public class SetCdActivity implements Activity {
    ConsoleWriter cw = new ConsoleWriter();

    public SetCdActivity(ConsoleWriter Cw) {
        cw = Cw;
    }

    @Override
    public void activity() {
        cw.write("The cd is changed to");
    }
}