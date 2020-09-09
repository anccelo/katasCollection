package models;

import java.math.BigDecimal;
import java.util.*;

public class Basket {

    List<Book> basketList = new ArrayList<>();
    List<Set<Book>> listOfSet = new ArrayList<>();


    public void addBook(Book book) {
        basketList.add(book);
    }

    public BigDecimal getPrice() {
        createSetOfBooks();
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal resultSet = BigDecimal.ZERO;

            for (int i = 0; i < listOfSet.size(); i++) {
                Set<Book> setOfBooks = listOfSet.get(i);
                for (Book book : setOfBooks) {
                    resultSet = resultSet.add(book.getPrice());
                }
                BigDecimal discountInEuroOfSet = resultSet.multiply(getDiscountOfSet(setOfBooks));
                resultSet = resultSet.subtract(discountInEuroOfSet);
                result = result.add(resultSet);
                resultSet = BigDecimal.ZERO;
            }
            return result;
    }

    public void createSetOfBooks() {
        Set<Book> discountsList = new HashSet<>();
        listOfSet.add(new HashSet<>());
        for (Book book : basketList) {
            Boolean verification = discountsList.add(book);
            System.out.println(verification);
            if (verification) {
                listOfSet.get(0).add(book);
            } else {
                listOfSet.add(new HashSet<>());
                listOfSet.get(1).add(book);
            }
        }
    }

    public BigDecimal getDiscountOfSet(Collection<Book> setOfBooks) {
        BigDecimal discount;
        switch (setOfBooks.size()) {
            case 2:
                discount = new BigDecimal("0.05");
                break;
            case 3:
                discount = new BigDecimal("0.10");
                break;
            case 4:
                discount = new BigDecimal("0.20");
                break;
            case 5:
                discount = new BigDecimal("0.25");
                break;
            default:
                discount = new BigDecimal("0");
        }

        return discount;
    }

}
