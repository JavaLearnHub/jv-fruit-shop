package service;

import dto.Transaction;
import model.OperationEnum;

import java.util.ArrayList;

public class TransactionParser {

    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public static ArrayList<Transaction> parseToTransaction(ArrayList<String> storeActivities) {
        ArrayList<Transaction> storeTransactions = new ArrayList<>();

        for (String activity : storeActivities) {
            String[] activityInfo = activity.strip().split(DATA_SEPARATOR);

            storeTransactions.add(new Transaction(OperationEnum.
                    getOperation(activityInfo[OPERATION_INDEX]),
                    activityInfo[PRODUCT_INDEX],
                    Integer.parseInt(activityInfo[QUANTITY_INDEX])));
        }

        return storeTransactions;
    }
}
