package phuocvu.org.btl_web_final.entity;

import javax.sound.sampled.Line;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {

    private List<LineItem> items;

    public Cart() {
        items = new ArrayList<LineItem>();
    }

    public List<LineItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public LineItem getItemById(int id) {
        for(LineItem i : items) {
            if(i.getProduct().getId() == id)
                return i;
        }
        return null;
    }

    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }



    public void addItem(LineItem item) {
        if(getItemById(item.getProduct().getId()) != null) {
            LineItem i = getItemById(item.getProduct().getId());
            i.setQuantity(i.getQuantity() + item.getQuantity());
        }
        else {
            items.add(item);
        }
    }

    public void removeItem(int id) {
        if(getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }

    public double getTotalMoney() {
        double t = 0;
        for(LineItem i : items) {
            t += i.getQuantity() * i.getPrice();
        }
        return t;
    }
}