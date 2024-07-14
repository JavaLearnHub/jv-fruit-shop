package dto;

import lombok.Getter;
import model.OperationEnum;

@Getter
public class Transaction {

    private final OperationEnum operation;
    private final String product;
    private final int quantity;

    public Transaction(OperationEnum operation, String product, int quantity) {
        this.operation = operation;
        this.product = product;
        this.quantity = quantity;
    }
}
