import java.io.Serializable;

public class SpotifySong implements Serializable {
    private String title;
    private int length;

    public SpotifySong(){}

    public String getTitle(){
        return title;
    }

    public int getLength(){
        return length;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setLength(int length){
        this.length = length;
    }
}