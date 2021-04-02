import by.belstu.it.Lab1.Truck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestTruck {

    private static Object[][] getInts() {
        return new Object[][]{
                {10},
                {2},
                {4},
                {58},
                {586},
        };
    }

    @Test
    @Disabled
    public void testGetLoadCapacity(){
        Truck tr = new Truck();
        tr.setLoadCapacity(124.32432F);
        assertEquals(124.32432F,tr.getLoadCapacity());
        System.out.println("After test");
    }

    @Test
    public void testGetIsFull() {
        Truck tr = new Truck();
        assertEquals(false, tr.getIsFull());
        System.out.println("Before test");
    }

    @ParameterizedTest
    @MethodSource("getInts")
    public void testParametrizedTest(int argument){
        System.out.println("parametrized test:"+argument);
        assertEquals(0, argument % 2);
    }
    @Test
    @DisplayName("Check all assert")
    void GroupTest(){
        Truck tr = new Truck();
        Assertions.assertAll("all assertion",
                ()->assertEquals(0,6%2),
                ()->assertEquals(false,tr.getIsFull()));
    }
}
