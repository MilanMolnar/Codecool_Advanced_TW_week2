public class Mp3Song extends Song{

    private int size;
    private int length;

    public Mp3Song(String title,int length) {
        super(title);
        this.length = length;
    }

    @Override
    public int getLength() {
        return length;
    }
}
