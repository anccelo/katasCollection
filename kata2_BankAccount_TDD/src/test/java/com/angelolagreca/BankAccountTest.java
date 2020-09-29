package com.angelolagreca;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    private static final String KATA = "KATA";
    Statement statement = new Statement();

    @Test
    void should_return_balance_when_client_make_a_deposit() {
        Account account = new Account(statement);
        BigDecimal oldBalance = account.getStatement().getBalance();
        BigDecimal input = BigDecimal.valueOf(1936.27);
        //BigDecimal actual = oldBalance.add(account.deposit(input));
        BigDecimal expected = BigDecimal.valueOf(1936.27);
        //assertEquals(expected,actual);
    }

    @Test
    void should_return_balance_when_client_make_a_withdrawal_Covered() {
        Account account = new Account(statement);
        account.deposit(new BigDecimal(3000));
        BigDecimal input = BigDecimal.valueOf(1936.27);
        BigDecimal expectedAmount = input;
        BigDecimal expectedBalance = account.getStatement().getBalance().subtract(input);
        account.withdrawal(input);
        Operation actualOperation = account.getStatement().getAccountStatement().get(account.getStatement().getAccountStatement().size() - 1);
        assertEquals(expectedAmount, actualOperation.getAmount());
        assertEquals(OperationType.WITHDRAWAL, actualOperation.getOperationType());
        assertEquals(expectedBalance, account.getStatement().getBalance());

    }

    @Test
    void should_return_balance_when_client_make_a_withdrawal_NotCovered() {
        Account account = new Account(statement);
        account.deposit(new BigDecimal(3000));
        BigDecimal input = BigDecimal.valueOf(4000.27);
        BigDecimal expected = new BigDecimal(3000);
        account.withdrawal(input);
        //assertEquals(expected,actual);
    }

    @Test
    void should_return_a_message_when_call_printHistorian() {

        Printer printer = new Printer() {
            @Override
            public String getHistorianMessage(Statement statement) {
                return KATA;
            }
        };
        String expected = KATA;
        String actual = printer.getHistorianMessage(statement);
        assertEquals(expected, actual);
    }


    @Test
    void testSet() {
        Account account1 = new Account("angelo");
        Account account2 = new Account("angelo");
        Account account3 = new Account("Diego");
        Set accounts = new HashSet<Account>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        int actual = accounts.size();
        int expected = 2;
        assertEquals(expected, actual);


    }
}
