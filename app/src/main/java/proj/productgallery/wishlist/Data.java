package proj.productgallery.wishlist;

/**
 * Created by sai on 21/9/17.
 */

public class Data {


    String name = null;
    boolean selected = false;

    public Data(String name, boolean selected) {
        this.name = name;
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}