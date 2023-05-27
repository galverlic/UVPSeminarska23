
package Categories.OutdoorSubsection;

import Categories.Product;

public class Chair extends Product {

    private boolean isFoldable;
    public Chair(int id, String name, double price,  boolean foldable, boolean isDiscounted, int quantityInStore, int quantityInWarehouse, int quantitySold) {
        super(id, name, price, isDiscounted, quantityInStore, quantityInWarehouse, quantitySold);
        this.isFoldable = foldable;
    }
        public boolean isFoldable() {
            return isFoldable;
        }

        public void setFoldable(boolean foldable) {
            isFoldable = foldable;
        }

    @Override
    public String toString() {
        return "Chair{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", isFoldable=" + isFoldable() +
                ", isDiscounted=" + getIsDiscounted() +
                ", quantityInStore=" + getQuantityInStore() +
                ", quantityInWarehouse=" + getQuantityInWarehouse() +
                ", quantitySold=" + getQuantitySold() +
                '}';
    }
    }

