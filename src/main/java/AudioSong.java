import java.io.Serializable;

public class AudioSong extends Song implements Serializable {
    private int length;

    public AudioSong(String title,int length) {
        super(title);
        this.length = length;
    }

    @Override
    public int getLength() {

        return length;
    }

}
