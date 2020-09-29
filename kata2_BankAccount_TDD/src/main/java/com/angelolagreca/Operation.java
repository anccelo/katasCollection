package com.angelolagreca;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

public class Operation {

    private LocalDate transactionDate;
    private BigDecimal amount;
    private OperationType operationType;

    public Operation(BigDecimal amount, OperationType operationType) {
        this.transactionDate = LocalDate.now();
        this.amount = amount;
        this.operationType = operationType;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    @Override
    public String toString() {
        return operationType + " -> " + amount + " Date=" + transactionDate;
    }
}
