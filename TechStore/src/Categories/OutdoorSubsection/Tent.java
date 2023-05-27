package Categories.OutdoorSubsection;

import Categories.Product;

public class Tent extends Product {

    private boolean isWaterproof;

    public Tent(int id, String name, double price, boolean isDiscounted, int quantityInStore, int quantityInWarehouse, int quantitySold, boolean isWaterproof) {
        super(id, name, price, isDiscounted, quantityInStore, quantityInWarehouse, quantitySold);
        this.isWaterproof = isWaterproof;
    }



    public boolean isWaterproof() {
        return isWaterproof;
    }

    public void setWaterproof(boolean waterproof) {
        isWaterproof = waterproof;
    }



    @Override
    public String toString() {
        return "Tent{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", isDiscounted=" + getIsDiscounted() +
                ", quantityInStore=" + getQuantityInStore() +
                ", quantityInWarehouse=" + getQuantityInWarehouse() +
                ", quantitySold=" + getQuantitySold() +
                ", isWaterproof=" + isWaterproof() +
                '}';
    }
}



