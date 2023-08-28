package entity;

public class Product {
    private String nameProduct;
    private String colorProduct;
    private long price;

    public Product(String nameProduct, int quantity, long price) {
    }


    public Product(String nameProduct, String colorProduct, long price) {
        this.nameProduct = nameProduct;
        this.colorProduct = colorProduct;
        this.price = price;
    }

    public Product() {

    }


    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getColorProduct() {
        return colorProduct;
    }

    public void setColorProduct(String colorProduct) {
        this.colorProduct = colorProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +

                ", nameProduct='" + nameProduct + '\'' +
                ", colorProduct='" + colorProduct + '\'' +
                ", price=" + price +
                '}';
    }
}
