package strategy;

import db.Storage;
import dto.Transaction;

public interface Operation {

    void operate(Transaction transaction, Storage storage);
}
