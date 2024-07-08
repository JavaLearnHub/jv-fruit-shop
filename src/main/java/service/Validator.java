package service;

import db.Storage;
import dto.Transaction;
import model.OperationEnum;

public class Validator {

    public static void validate(Transaction transaction, Storage storage) throws WrongQuantityException {

        if (transaction.getOperation().equals(OperationEnum.PURCHASE)) {
            int productQuantity = storage.getQuantity(transaction.getProduct()).orElse(0);

            if (productQuantity < transaction.getQuantity()) {
                throw new WrongQuantityException("Wrong product quantity.");
            }
        }

    }
}
