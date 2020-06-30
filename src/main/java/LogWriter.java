import java.io.FileWriter;
import java.io.IOException;

public class LogWriter extends Writer {

    @Override
    public void write(String string) {
        try {
            FileWriter writer = new FileWriter("log.txt", true);
            writer.write(string);
            writer.write("\r\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

