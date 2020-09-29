package com.angelolagreca;

public class Printer {

    public String getHistorianMessage(Statement statement) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("");

        for (Operation op : statement.getAccountStatement()) {
            stringBuilder.append(op);
            stringBuilder.append("\n");
        }
        stringBuilder.append("------------------------\n");
        stringBuilder.append("Balance: ");
        stringBuilder.append(statement.getBalance());


        return stringBuilder.toString();
    }

}
