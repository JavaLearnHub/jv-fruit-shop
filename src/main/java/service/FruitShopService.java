package service;

import db.Storage;
import dto.Transaction;
import model.OperationEnum;
import strategy.*;

import java.util.HashMap;
import java.util.List;

import static model.OperationEnum.*;
import static model.OperationEnum.SUPPLY;

public class FruitShopService {

    private final Storage storage;
    private static final HashMap<OperationEnum, Operation> storeOperations = new HashMap<>();

    public FruitShopService(Storage storage) {
        this.storage = storage;
    }

    static {
        storeOperations.put(BALANCE, new BalanceOperation());
        storeOperations.put(PURCHASE, new PurchaseOperation());
        storeOperations.put(RETURN, new ReturnOperation());
        storeOperations.put(SUPPLY, new SupplyOperation());
    }

    public void handleActivities(String filePathToRead, String filePathToWrite) throws WrongQuantityException {

        List<String> storeActivities = Reader.readLines(filePathToRead);

        List<Transaction> storeTransactions = TransactionParser.parseToTransaction(storeActivities);

        for (Transaction transaction : storeTransactions) {
            Validator.validate(transaction, storage);
            storeOperations.get(transaction.getOperation()).operate(transaction, storage);
        }

        Writer.writeToFile(filePathToWrite, ReportCreator.createReport(storage));
    }
}
