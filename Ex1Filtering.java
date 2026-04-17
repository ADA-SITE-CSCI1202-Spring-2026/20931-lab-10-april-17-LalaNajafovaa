import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex1Filtering {

    static class Product {
        String name;
        double price;
        boolean inStock;

        Product(String name, double price, boolean inStock) {
            this.name = name;
            this.price = price;
            this.inStock = inStock;
        }

        @Override
        public String toString() {
            return name + " ($" + price + ", inStock=" + inStock + ")";
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Notebook", 12.99, true));
        products.add(new Product("Laptop", 899.00, true));
        products.add(new Product("Pen", 1.50, true));
        products.add(new Product("Monitor", 250.00, false));
        products.add(new Product("USB Cable", 8.00, true));
        products.add(new Product("Headphones", 49.99, false));

        Predicate<Product> isAffordable = p -> p.price < 50 && p.inStock;

        products.removeIf(isAffordable.negate());

        System.out.println(products);
    }
}
