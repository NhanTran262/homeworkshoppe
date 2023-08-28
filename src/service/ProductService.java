package service;

import entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ProductService {
    protected static List<Product> products = new ArrayList<Product>();
    public static Scanner sc = new Scanner(System.in);
    private static int productNumber = 0;
    private final static String productName = "sanpham";
    private final static String productColor = "mau";

    public static void addProduct() {
        for (int index = 1; index <= 100; index++) {
            plusProduct();
        }
        pageSize = 20;
    }

    private static void plusProduct() {
        String nameProduct = addNameProduct();
        String colorProduct = addColorProduct();
        long price = setPrice();
        Product product = new Product(nameProduct, colorProduct, price);
        products.add(product);
    }

    public static String addNameProduct() {
        productNumber++;
        return productName + productNumber;
    }

    public static String addColorProduct() {
        return productColor + productNumber;
    }

    public static long setPrice() {
        return randomPrice();
    }

    private static long randomPrice() {
        return nextLongBetween(10, 1000);
    }

    public static long nextLongBetween(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static void printList() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static Product getProduct(int index) {
        return products.get(index);
    }

    private static int pageSize;

    public List<Product> getProductByPage(int pageIndex) {
        int starIndex = (pageIndex - 1) * pageSize;
        int endIndex = Math.min(starIndex + pageSize, products.size());
        return products.subList(starIndex, endIndex);
    }

    public static void printPage() {
        String input;
        do {
            ProductService productService = new ProductService();
            System.out.println("Please! Enter the page you want to see: ");
            int pageIndex = sc.nextInt();
            sc.nextLine();
            List<Product> products = productService.getProductByPage(pageIndex);
            System.out.println("Page:" + pageIndex);
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.println("Do you want to see the next page (Y/N): ");
            input = sc.nextLine();
        } while (input.equalsIgnoreCase("Y"));
        System.out.println("out");
    }
}


