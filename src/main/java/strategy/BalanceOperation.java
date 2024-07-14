package strategy;

import db.Storage;
import dto.Transaction;

public class BalanceOperation implements Operation {

    @Override
    public void operate(Transaction transaction, Storage storage) {

        storage.saveToStorage(transaction.getProduct(), transaction.getQuantity());
    }
}
