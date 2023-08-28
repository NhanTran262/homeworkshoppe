package service;
import entity.CartItem;
import entity.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static service.ProductService.products;

public class CartService {
    protected static List<CartItem> items = new ArrayList<CartItem>();
    public static Scanner sc = new Scanner(System.in);

    public static void addToCart(String nameProduct) {
        Product product = null;
        for (Product p : products) {
            if (p.getNameProduct().equalsIgnoreCase(nameProduct)) {
                product = p;
                break;
            }
        }
        if (product != null) {
            System.out.println("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            CartItem newItem = new CartItem(product, quantity);
            items.add(newItem);
            System.out.println("Product added to cart successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    public static void buyItem() {
        CartService cartservice = new CartService();
        System.out.println("Welcome to the shopping cart!");
        String input;
        do {
            System.out.println("Enter product name: ");
            String productName = sc.nextLine();
            cartservice.addToCart(productName);
            System.out.println("Do you want to add another product? (Y/N): ");
            input = sc.nextLine();
        } while (input.equalsIgnoreCase("Y"));
        System.out.println();
        cartservice.printCart();
        double totalPrice = cartservice.getTotalPrice();
        System.out.println("Total Price: " + totalPrice);
        sc.close();
    }

    public double getTotalPrice() {
        double totalPrice=0;
        for (CartItem item : items) {
            totalPrice += item.getSubtotal();
        }
        return totalPrice;
    }

    public static void printCart() {
        if (!items.isEmpty()) {
            System.out.println("Your shopping cart contains: ");
            for (CartItem item : items) {
                System.out.println(item.getProduct() + " - Quantity: " + item.getQuantity() + " - Subtotal: $" + item.getSubtotal());
            }
        } else {
            System.out.println("Your shopping cart is empty.");
        }
    }
}

