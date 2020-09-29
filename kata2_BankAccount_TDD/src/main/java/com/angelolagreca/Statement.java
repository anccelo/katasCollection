package com.angelolagreca;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Statement {
    private List<Operation> accountStatement = new ArrayList<>();
    private BigDecimal balance = BigDecimal.ZERO;

    public void addOperation(Operation operation) {
        accountStatement.add(operation);
        if (operation.getOperationType().equals(OperationType.DEPOSIT))
            this.balance = this.balance.add(operation.getAmount());
        else
            this.balance = this.balance.subtract(operation.getAmount());
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public List<Operation> getAccountStatement() {
        return Collections.unmodifiableList(accountStatement);
    }

}
