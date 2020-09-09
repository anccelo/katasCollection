import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    void should_return_zero_when_send_a_empty_string(){
        String input= "";
        int actual =  StringCalculator.add(input);
        int expected = 0;
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @CsvSource({"1,1","2,2","0,0","12,12"})
    void should_return_the_number_itself_when_send_a_single_number_as_string(String input, int expected){
        int actual =  StringCalculator.add(input);
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,1: 4","14,6: 20","1900,26:1926","1901,24,1:1926"}, delimiter = ':')
    void should_return_the_sum_when_send_two_number_separated_with_comma(String input, int expected){
        int actual =  StringCalculator.add(input);
        assertEquals(expected,actual);
    }

    @Test
    void should_return_the_sum_when_send_more_number_separated_with_commas_and_a_line_between_numbers(){
        String input= "1\n2,3";
        int actual =  StringCalculator.add(input);
        int expected = 6;
        assertEquals(expected,actual);
    }

    @Test
    void should_return_sum_when_send_a_delimiter_and_some_number_into_string(){
        String input= "//;\n1;2";
        int actual =  StringCalculator.add(input);
        int expected = 3;
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @MethodSource("parametrizedExecption")
    void test_exception(String input, String expected){
        assertThatThrownBy(() -> {
            int actual =  StringCalculator.add(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(expected);
    }

    private static Stream<Arguments> parametrizedExecption() {
        return Stream.of(
                Arguments.of("-3,1", "negatives not allowed, but follows numbers is present: [-3]"),
                Arguments.of("14,-6", "negatives not allowed, but follows numbers is present: [-6]"),
                Arguments.of("-1", "negatives not allowed, but follows numbers is present: [-1]"),
                Arguments.of("-1901,-24,1", "negatives not allowed, but follows numbers is present: [-1901, -24]")
        );
    }

//    @Test
//    void test_exception_when_input_have_particular_form(){
//        String input= "//;\n-1;2";
//        assertThatThrownBy(() -> {
//            int actual =  StringCalculator.add(input);
//        }).isInstanceOf(IllegalArgumentException.class).;
//
//    }





}

