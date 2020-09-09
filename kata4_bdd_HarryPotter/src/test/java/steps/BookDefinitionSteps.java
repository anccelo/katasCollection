package steps;

import models.Basket;
import models.Book;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BookDefinitionSteps {

    private static final String VOLUME = "volume %s";

    private Book book;
    private  Basket basket;
//-------------step 1------------------
    @Given("A book")
    public void givenABook() {
        book = new Book();
    }

    @Then("The book price is 8 euros")
    public void thenTheBookPriceIs8Euros(){
        BigDecimal expected = new BigDecimal(8);
        BigDecimal actual   = book.getPrice();
        assertEquals(expected, actual);
    }

    //-------------step 2------------------à plus

    @Given("A basket")
    public void givenABasket(){
        basket = new Basket();
    }

    @When("I add a book to basket")
    public void IAddABookToBasket(){
        basket.addBook(book);
    }

    @Then("The basket price is 8 euros")
    public void TheBasketPriceIsEightEuros(){
        BigDecimal expected = new BigDecimal(8);
        BigDecimal actual   = basket.getPrice();
        assertEquals(expected, actual);
    }
//-------------step 3------------------

    @When("I add a book of volume $volume to basket")
    public void IAddABookOfVolumeToBasket(@Named("volume") Integer volumeNumber){
        Book book = new Book(String.format(VOLUME, volumeNumber.toString()));
        basket.addBook(book);
    }

    @Then("The basket price is $price euros")
    public void TheBasketPriceIs_XX_Euros(@Named("price") String basketPrice){
        BigDecimal expected = new BigDecimal(basketPrice);
        BigDecimal actual   = basket.getPrice();
        assertEquals(expected, actual);
    }

    @When("I add $quantity book(s) of volume $volume to basket")
    public void IAddABooksOfVolumeToBasket(@Named("volume") Integer volumeNumber, @Named("quantity") Integer volumeQuantity ){
        Book book = new Book(String.format(VOLUME, volumeNumber.toString()));
        for(int i =0; i<volumeQuantity; i++){
            basket.addBook(book);
        }

    }



}
