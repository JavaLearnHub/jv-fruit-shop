package service;

import db.Storage;
import dto.Transaction;
import model.OperationEnum;

public class Validator {

    public static void validate(Transaction transaction, Storage storage) throws WrongQuantityException {
        int productQuantity = storage.getQuantity(transaction.getProduct()).orElse(0);

        if (checkQuantity(transaction, productQuantity)) {
            throw new WrongQuantityException("Wrong product quantity.");
        }
    }
    private static boolean checkQuantity(Transaction transaction, int productQuantity){
        return (transaction.getOperation().equals(OperationEnum.PURCHASE) &&
                productQuantity < transaction.getQuantity()) ||
                transaction.getQuantity() == 0;
    }
}
