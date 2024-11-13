import java.util.*;

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {return name;}
    public double getPrice() {return price;}
    public int getQuantity() {return quantity;}
    public double getTotalPrice() {return price * quantity;}
}

class ShoppingCart {
    private ArrayList<Item> items;

    public ShoppingCart() {this.items = new ArrayList<>();}

    public void addItem(String name, double price, int quantity) {
        Item item = new Item(name, price, quantity);
        items.add(item);
    }

    private double getDiscount(double price) {
        if(price >= 1000 && price <= 2000) {return 0.10;} 
        else if(price > 2000 && price <= 3000) {return 0.15;} 
        else if(price > 3000 && price <= 5000) {return 0.20;} 
        else if(price > 5000) {return 0.25;}
        else {return 0.0;}
    }

    public void generateBill() {
        double totalAmount = 0;
        System.out.println("Item\t\t\tPrice\t\tQuantity\tTotal\t\tDiscount\tFinal Price");

        for (Item item : items) {
            double totalPrice = item.getTotalPrice();
            double discountRate = getDiscount(totalPrice);
            double discountAmount = totalPrice * discountRate;
            double finalPrice = totalPrice - discountAmount;
            
            System.out.printf("%s\t\t%.2f\t\t%d\t\t%.2f\t\t%.2f\t\t%.2f\n", 
                item.getName(), item.getPrice(), item.getQuantity(), totalPrice, discountAmount, finalPrice);
            
            totalAmount += finalPrice;
        }

        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("Total Amount: %.2f\n", totalAmount);
    }
}

public class ShoppingCartTest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        cart.addItem("Earbuds Pro", 5000, 1);
        cart.addItem("Smart Watch", 2500, 1);
        cart.addItem("Mobile Phone", 9999, 1);
        cart.addItem("Gift Card", 100, 10);
        cart.addItem("Key Chain", 500, 2);

        cart.generateBill();
    }
}