import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class OneHundredDoorsTest {

    @Test
    void the_door_should_be_open_when_the_door_number_is_a_perfect_squares() {
        OneHundredDoors.crossingTheDoorsOneHundredOfTimes();
        for (int i = 0; i < 100; i++) {
            double sq = Math.sqrt(i + 1);
            if (sq - Math.floor(sq) == 0) {
                assertTrue(OneHundredDoors.doors[i]);
            } else {
                assertFalse(OneHundredDoors.doors[i]);
            }
        }
    }
}
