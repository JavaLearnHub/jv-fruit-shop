package db;

import java.util.Optional;

public interface Storage {
    void saveToStorage(String product, int quantity);

    Optional<Integer> getQuantity(String product);

    String[] getProductsNames();
}
