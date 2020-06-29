import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items = new ArrayList<MenuItem>();
    private List<Writer> writers;

    public void addItem(MenuItem mitem){
        items.add(mitem);
    }
    public void show(){
        for (MenuItem option:
             this.items) {
            System.out.println(option.getTitle());
        }
    }
    public void addWriter(Writer writer){

    }
}
