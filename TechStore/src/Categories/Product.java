package Categories;

import Categories.OutdoorSubsection.Chair;
import Categories.OutdoorSubsection.Tent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Product {
    private final int id;
    private String name;
    private double price;
    private boolean isDiscounted;
    private int quantityInStore;
    private int quantityInWarehouse;
    private int quantitySold;

    private double totalRevenue;

    public Product(int id, String name, double price, boolean isDiscounted, int quantityInStore, int quantityInWarehouse, int quantitySold) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isDiscounted = isDiscounted;
        this.quantityInStore = quantityInStore;
        this.quantityInWarehouse = quantityInWarehouse;
        this.quantitySold = quantitySold;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isDiscounted=" + isDiscounted +
                ", quantityInStore=" + quantityInStore +
                ", quantityInWarehouse=" + quantityInWarehouse +
                ", quantitySold=" + quantitySold +
                '}';
    }
    public static void saveProducts(List<Product> products, String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            for (Product product : products) {
                if (product instanceof Tent tent) {
                    writer.write(String.format(
                            "Tent,%d,%s,%.2f,%s,%d,%d,%d,%s\n",
                            tent.getId(),
                            tent.getName(),
                            tent.getPrice(),
                            tent.getIsDiscounted(),
                            tent.getQuantityInStore(),
                            tent.getQuantityInWarehouse(),
                            tent.getQuantitySold(),
                            tent.isWaterproof()
                    ));
                } else if (product instanceof Chair chair) {
                    writer.write(String.format(
                            "Chair,%d,%s,%.2f,%s,%d,%d,%d,%s\n",
                            chair.getId(),
                            chair.getName(),
                            chair.getPrice(),
                            chair.getIsDiscounted(),
                            chair.getQuantityInStore(),
                            chair.getQuantityInWarehouse(),
                            chair.getQuantitySold(),
                            chair.isFoldable()
                    ));
                }
                // Add more product types as needed
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> loadProducts(String filename) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            while (line != null) {

                String[] productData = line.split(",");
                Product product = null;
                String productType = productData[0].trim();
                if (productType.equals("Tent")) {
                    product = new Tent(
                            Integer.parseInt(productData[1]),
                            productData[2],
                            Double.parseDouble(productData[3]),
                            Boolean.parseBoolean(productData[4]),
                            Integer.parseInt(productData[5]),
                            Integer.parseInt(productData[6]),
                            Integer.parseInt(productData[7]),
                            Boolean.parseBoolean(productData[8])
                    );
                } else if (productType.equals("Chair")) {
                    product = new Chair(
                            Integer.parseInt(productData[1]),
                            productData[2],
                            Double.parseDouble(productData[3]),
                            Boolean.parseBoolean(productData[4]),
                            Boolean.parseBoolean(productData[5]),
                            Integer.parseInt(productData[6]),
                            Integer.parseInt(productData[7]),
                            Integer.parseInt(productData[8])
                    );
                }

                if (product != null) {
                    products.add(product);
                }
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    // Getters and setters for attributes
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getIsDiscounted() {
        return isDiscounted;
    }

    public void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }

    public int getQuantityInStore() {
        return quantityInStore;
    }

    public void setQuantityInStore(int quantityInStore) {
        this.quantityInStore = quantityInStore;
    }

    public int getQuantityInWarehouse() {
        return quantityInWarehouse;
    }

    public void setQuantityInWarehouse(int quantityInWarehouse) {
        this.quantityInWarehouse = quantityInWarehouse;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public void sellProduct(int quantity) {
        if (quantity <= this.quantityInStore) {
            this.quantityInStore -= quantity;
            this.quantitySold += quantity;
            this.totalRevenue += quantity * this.price;
        } else {
            System.out.println("Error: Not enough items in store to fulfill your order.");
        }
    }

    public double getTotalRevenue() {
        return this.totalRevenue;
    }
    public void returnProduct(int quantity) {
        if (quantity <= this.quantitySold) {
            this.quantityInStore += quantity;
            this.quantitySold -= quantity;
        } else {
            System.out.println("Error: You cannot return more items than you purchased.");
        }
    }
}

