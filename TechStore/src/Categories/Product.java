package Categories;

import Categories.ComputerElectronicsSubsection.Laptop;
import Categories.OutdoorSubsection.Chair;
import Categories.OutdoorSubsection.Tent;
import Categories.PhonesSubsection.MobilePhones;
import Categories.PhonesSubsection.PhoneCases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Product {
    private final int id;
    private final String name;
    private final double price;
    private final boolean isDiscounted;
    private int quantityInStore;
    private final int quantityInWarehouse;
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
                            "Tent,%d,%s,%.2f,%b,%d,%d,%d,%b\n",
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
                            "Chair,%d,%s,%.2f,%b,%b,%d,%d,%d\n",
                            chair.getId(),
                            chair.getName(),
                            chair.getPrice(),
                            chair.isFoldable(),
                            chair.getIsDiscounted(),
                            chair.getQuantityInStore(),
                            chair.getQuantityInWarehouse(),
                            chair.getQuantitySold()
                    ));
                } else if (product instanceof Laptop laptop) {
                    writer.write(String.format(
                            "Laptop,%d,%s,%.2f,%d,%b,%d,%d,%d\n",
                            laptop.getId(),
                            laptop.getName(),
                            laptop.getPrice(),
                            laptop.getStorageSpace(),
                            laptop.getIsDiscounted(),
                            laptop.getQuantityInStore(),
                            laptop.getQuantityInWarehouse(),
                            laptop.getQuantitySold()
                    ));
                } else if (product instanceof MobilePhones phone) {
                    writer.write(String.format(
                            "MobilePhone,%d,%s,%.2f,%b,%s,%d,%d,%d\n",
                            phone.getId(),
                            phone.getName(),
                            phone.getPrice(),
                            phone.getIsDiscounted(),
                            phone.getBrand(),
                            phone.getQuantityInStore(),
                            phone.getQuantityInWarehouse(),
                            phone.getQuantitySold()
                    ));
                } else if (product instanceof PhoneCases phoneCase) {
                    writer.write(String.format(
                            "PhoneCase,%d,%s,%.2f,%b,%s,%d,%d,%d\n",
                            phoneCase.getId(),
                            phoneCase.getName(),
                            phoneCase.getPrice(),
                            phoneCase.getIsDiscounted(),
                            phoneCase.getColor(),
                            phoneCase.getQuantityInStore(),
                            phoneCase.getQuantityInWarehouse(),
                            phoneCase.getQuantitySold()
                    ));
                }

            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> loadProducts(String filename) {
        List<Product> products = new ArrayList<>();
        try (InputStream is = Product.class.getResourceAsStream(filename);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
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
                } else if (productType.equals("Laptop")) {
                    product = new Laptop(
                            Integer.parseInt(productData[1]),
                            productData[2],
                            Double.parseDouble(productData[3]),
                            Integer.parseInt(productData[4]),
                            Boolean.parseBoolean(productData[5]),
                            Integer.parseInt(productData[6]),
                            Integer.parseInt(productData[7]),
                            Integer.parseInt(productData[8])
                    );
                } else if (productType.equals("MobilePhone")) {
                    product = new MobilePhones(
                            Integer.parseInt(productData[1]),
                            productData[2],
                            Double.parseDouble(productData[3]),
                            Boolean.parseBoolean(productData[4]),
                            productData[5],
                            Integer.parseInt(productData[6]),
                            Integer.parseInt(productData[7]),
                            Integer.parseInt(productData[8])
                    );
                } else if (productType.equals("PhoneCase")) {
                    product = new PhoneCases(
                            Integer.parseInt(productData[1]),
                            productData[2],
                            Double.parseDouble(productData[3]),
                            Boolean.parseBoolean(productData[4]),
                            productData[5],
                            Integer.parseInt(productData[6]),
                            Integer.parseInt(productData[7]),
                            Integer.parseInt(productData[8])
                    );
                }

                if (product != null) {
                    products.add(product);
                }
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


    public double getPrice() {
        return price;
    }



    public boolean getIsDiscounted() {
        return isDiscounted;
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



    public int getQuantitySold() {
        return quantitySold;
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


    public void returnProduct(int quantity) {
        if (quantity <= this.quantitySold) {
            this.quantityInStore += quantity;
            this.quantitySold -= quantity;
        } else {
            System.out.println("Error: You cannot return more items than you purchased.");
        }
    }
}

