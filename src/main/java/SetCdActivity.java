public class SetCdActivity implements Activity {
    Cd cd;
    ConsoleWriter cw = new ConsoleWriter();


    public SetCdActivity(ConsoleWriter Cw, Cd cd) {
        cw = Cw;
        this.cd = cd;
    }

    @Override
    public void activity() {
        cw.write("The cd is changed to" + cd.getTitle());
    }
}