package db;

import java.util.HashMap;
import java.util.Optional;

public class StorageImpl implements Storage{
    private static final HashMap<String, Integer> STORAGE = new HashMap<>();

    @Override
    public void saveToStorage(String product, int quantity) {
        STORAGE.put(product, quantity);
    }

    public Optional<Integer> getQuantity(String product) {
        return Optional.ofNullable(STORAGE.get(product));
    }

    public String[] getProductsNames(){
        return STORAGE.keySet().toArray(new String[0]);
    }
}
