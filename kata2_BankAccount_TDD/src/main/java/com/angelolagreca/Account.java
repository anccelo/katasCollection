package com.angelolagreca;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private String name;
    private Statement statement;

    Printer printer;

    public Account(Statement statement) {
        this.statement = statement;
    }

    public Account(Statement statement, Printer printer) {
        this.statement = statement;
        this.printer = printer;
    }

    public Account(String name) {
        this.name = name;
        this.statement = new Statement();
    }

    public Statement getStatement() {
        return statement;
    }

    public void deposit(BigDecimal amount) {
        Operation depositOperation = new Operation(amount, OperationType.DEPOSIT);
        statement.addOperation(depositOperation);
    }

    public void withdrawal(BigDecimal amount) {
        Operation depositOperation = new Operation(amount, OperationType.WITHDRAWAL);
        if (statement.getBalance().compareTo(amount) != -1)
            statement.addOperation(depositOperation);
    }

    public void printHistorian() {
        System.out.println(printer.getHistorianMessage(statement));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
