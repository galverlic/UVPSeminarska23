package Categories.PhonesSubsection;

import Categories.Product;

public class PhoneCases extends Product {

    private final String color;
    public PhoneCases(int id, String name, double price, boolean isDiscounted, String color, int quantityInStore, int quantityInWarehouse, int quantitySold) {
        super(id, name, price, isDiscounted, quantityInStore, quantityInWarehouse, quantitySold);
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        color = color;
    }
    @Override
    public String toString() {
        return "Phone Case{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", isDiscounted=" + getIsDiscounted() +
                ", color='" + getColor() +
                ", quantityInStore=" + getQuantityInStore() +
                ", quantityInWarehouse=" + getQuantityInWarehouse() +
                ", quantitySold=" + getQuantitySold() +
                '}';
    }
}
