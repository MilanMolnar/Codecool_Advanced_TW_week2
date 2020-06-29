public class ConsoleWriter extends Writer {
    @Override
    public void write(String string) {
        System.out.println(string);
    }
}
