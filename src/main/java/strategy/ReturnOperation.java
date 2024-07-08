package strategy;

import db.Storage;
import dto.Transaction;

public class ReturnOperation implements Operation {

    @Override
    public void operate(Transaction transaction, Storage storage) {

        String transactionProduct = transaction.getProduct();
        int oldQuantity = storage.getQuantity(transactionProduct).orElse(0);

        storage.saveToStorage(transactionProduct, oldQuantity + transaction.getQuantity());
    }

}
