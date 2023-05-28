package Categories.ComputerElectronicsSubsection;

import Categories.Product;

public class Laptop extends Product {
    private int storageSpace;

    public Laptop(int id, String name, double price, int storageSpace, boolean isDiscounted, int quantityInStore, int quantityInWarehouse, int quantitySold) {
        super(id, name, price, isDiscounted, quantityInStore, quantityInWarehouse, quantitySold);
        this.storageSpace = storageSpace;
    }

    public int getStorageSpace(){
        return storageSpace;
    }

    public void setStorageSpace(int storageSpace){
        this.storageSpace = storageSpace;
    }
    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", storageSpace=" + getStorageSpace() +
                ", isDiscounted=" + getIsDiscounted() +
                ", quantityInStore=" + getQuantityInStore() +
                ", quantityInWarehouse=" + getQuantityInWarehouse() +
                ", quantitySold=" + getQuantitySold() +
                '}';
    }
}
