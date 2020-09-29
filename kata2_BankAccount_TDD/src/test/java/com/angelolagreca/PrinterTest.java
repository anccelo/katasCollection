package com.angelolagreca;

import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PrinterTest {

    private final LocalDate transactionDate = LocalDate.now();
    final Printer printer = new Printer();


    @Test
    void historianMessageTest() {
        Statement statement = new Statement();
        Operation operation1 = new Operation(new BigDecimal(1000), OperationType.DEPOSIT);
        Operation operation2 = new Operation(new BigDecimal(1100), OperationType.DEPOSIT);
        Operation operation3 = new Operation(new BigDecimal(500), OperationType.WITHDRAWAL);
        statement.addOperation(operation1);
        statement.addOperation(operation2);
        statement.addOperation(operation3);

        String[] stringActual = printer.getHistorianMessage(statement).split("\n");
        //System.out.println(printer.getHistorianMessage(statement));

        assertEquals("DEPOSIT -> 1000 Date=" + transactionDate, stringActual[0]);
        assertEquals("DEPOSIT -> 1100 Date=" + transactionDate, stringActual[1]);
        assertEquals("WITHDRAWAL -> 500 Date=" + transactionDate, stringActual[2]);


    }
}
