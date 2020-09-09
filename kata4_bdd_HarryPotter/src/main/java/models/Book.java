package models;

import java.math.BigDecimal;
import java.util.Objects;

public class Book {


    private String name;
    private BigDecimal price = new BigDecimal(8);

    public Book() {
    }

    public  Book(String name){
        this.name = name;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name);
    }

}
