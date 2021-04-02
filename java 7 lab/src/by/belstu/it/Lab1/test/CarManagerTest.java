package by.belstu.it.Lab1.test;

import main.java.by.belstu.it.Lab1.Car;
import main.java.by.belstu.it.Lab1.CargoPassenger;
import main.java.by.belstu.it.Lab1.SimpleCar;
import main.java.by.belstu.it.Lab1.Truck;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CarManagerTest {
    @Test
    public int testCountUp(){
        HashSet<Car> set1= new HashSet<>() ;
        set1.add(new CargoPassenger(){});
        set1.add(new Truck(){});
        set1.add(new Truck(){});
        set1.add(new SimpleCar(){});
        set1.add(new CargoPassenger(){});
        CarManager carManager = new CarManager();
        assertEquals()

    }
}
