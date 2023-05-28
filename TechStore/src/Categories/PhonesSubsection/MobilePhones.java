package Categories.PhonesSubsection;

import Categories.Product;

public class MobilePhones extends Product {
    private String brand;

    public MobilePhones(int id, String name, double price, boolean isDiscounted, String brand, int quantityInStore, int quantityInWarehouse, int quantitySold) {
        super(id, name, price, isDiscounted, quantityInStore, quantityInWarehouse, quantitySold);
        this.brand = brand;
    }

    public String getBrand(){
        return brand;
    }

    public void brand(String brand){
        brand = brand;
    }

    @Override
    public String toString() {
        return "Mobile phone{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", isDiscounted=" + getIsDiscounted() +
                ", brand=" + getBrand() +
                ", quantityInStore=" + getQuantityInStore() +
                ", quantityInWarehouse=" + getQuantityInWarehouse() +
                ", quantitySold=" + getQuantitySold() +
                '}';
    }
}
