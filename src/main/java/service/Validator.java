package service;

import db.Storage;
import dto.Transaction;
import model.OperationEnum;

public class Validator {

    public static void validate(Transaction transaction, Storage storage) throws WrongQuantityException {
        int productQuantity = storage.getQuantity(transaction.getProduct()).orElse(0);

        if (!isValidQuantity(transaction, productQuantity)) {
            throw new WrongQuantityException("Wrong product quantity.");
        }
    }

    private static boolean isValidQuantity(Transaction transaction, int productQuantity) {
        return (transaction.getOperation().equals(OperationEnum.PURCHASE) &&
                productQuantity >= transaction.getQuantity()) ||
                (!transaction.getOperation().equals(OperationEnum.PURCHASE) &&
                        transaction.getQuantity() != 0);
    }
}
