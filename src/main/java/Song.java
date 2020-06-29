public abstract class Song {
    private String title;
    private int length;

    public Song(){}

    public Song(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    };
    public abstract int getLength();

}
