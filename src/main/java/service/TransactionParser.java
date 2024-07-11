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

        return new ArrayList<>(storeActivities.stream()
                .map(a -> a.strip().split(DATA_SEPARATOR))
                .map(a -> new Transaction(OperationEnum.getOperation(a[OPERATION_INDEX]),
                        a[PRODUCT_INDEX],
                        Integer.parseInt(a[QUANTITY_INDEX])))
                .toList());
    }
}
