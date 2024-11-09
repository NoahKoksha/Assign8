 package koksha;

public class Textbook {
    private int sku;
    private String title;
    private double price;
    private int quantity;

    public Textbook(int sku, String title, double price, int quantity) {
        this.sku = sku;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public int getSku() {
        return sku;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "SKU: " + sku + ", Title: " + title + ", Price: $" + price + ", Quantity: " + quantity;
    }
}
