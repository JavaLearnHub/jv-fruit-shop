import db.Storage;
import db.StorageImpl;
import dto.Transaction;
import model.OperationEnum;
import service.*;
import strategy.*;

import java.util.ArrayList;
import java.util.HashMap;

import static model.OperationEnum.*;

public class FruitShop {

    private static final Storage storage = new StorageImpl();
    private static final HashMap<OperationEnum, Operation> storeOperations = new HashMap<>();
    private static final String FILE_PATH_TO_READ = "src/main/resources/fruitShopInfo";
    private static final String FILE_PATH_TO_WRITE = "src/main/resources/fruitShopInfoResult";


    public static void main(String[] args) throws WrongQuantityException {
        storeOperations.put(BALANCE, new BalanceOperation());
        storeOperations.put(PURCHASE, new PurchaseOperation());
        storeOperations.put(RETURN, new ReturnOperation());
        storeOperations.put(SUPPLY, new SupplyOperation());

        ArrayList<String> storeActivities = Reader.readLines(FILE_PATH_TO_READ);

        ArrayList<Transaction> storeTransactions = TransactionParser.parseToTransaction(storeActivities);

        for (Transaction transaction : storeTransactions) {
            Validator.validate(transaction, storage);
            storeOperations.get(transaction.getOperation()).operate(transaction, storage);
        }

        Writer.writeToFile(FILE_PATH_TO_WRITE, ReportCreator.createReport(storage));
    }
}
