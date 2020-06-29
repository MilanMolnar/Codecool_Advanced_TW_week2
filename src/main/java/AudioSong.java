public class AudioSong extends Song {
    private float samplingFrequency;
    private int length;

    public AudioSong(String title,int length) {
        super(title);
        this.length = length;
    }



    public float getSamplingFrequency() {
        return samplingFrequency;
    }

    @Override
    public int getLength() {
        return length;
    }
}
