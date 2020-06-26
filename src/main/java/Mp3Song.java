public class Mp3Song extends Song{

    private int size;

    public Mp3Song(int size) {
        this.size = size;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public int getLength() {
        return 0;
    }
}
