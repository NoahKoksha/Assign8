package koksha;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private Map<Integer, Textbook> store;

    public Store() {
        store = new HashMap<>();
    }

    public String addTextbook(int sku, String title, double price, int quantity) {
        if (store.containsKey(sku)) {
            return "Error";
        }
        if (price <= 0 || quantity < 0) {
            return "Error";
        }
        store.put(sku, new Textbook(sku, title, price, quantity));
        return "Success";
    }

    public String removeTextbook(int sku) {
        if (store.remove(sku) != null) {
            return "Success";
        } else {
            return "Error";
        }
    }

    public String displayTextbook(int sku) {
        Textbook textbook = store.get(sku);
        return (textbook != null) ? textbook.toString() : "Error";
    }

    public Map<Integer, Textbook> displayAllTextbooks() {
        return store;
    }
}
