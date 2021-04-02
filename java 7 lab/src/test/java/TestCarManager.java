import by.belstu.it.Lab1.Car;
import by.belstu.it.Lab1.CarStation.TaxiStation;
import by.belstu.it.Lab1.CargoPassenger;
import by.belstu.it.Lab1.SimpleCar;
import by.belstu.it.Lab1.Truck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;

import static by.belstu.it.Lab1.CarManager.CarManager.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCarManager {
    @Test
    public void testGetPriceOfTaxiStation(){
        System.out.println("Before test");
        TaxiStation taxiStation = new TaxiStation();
        taxiStation.addCarToTaxiStation(new CargoPassenger());
        Truck truck = new Truck();
        truck.setPrice(42.2F);
        taxiStation.addCarToTaxiStation(truck);
        taxiStation.addCarToTaxiStation(truck);
        taxiStation.addCarToTaxiStation(truck);
        SimpleCar sc = new SimpleCar();
        sc.setPrice(3.4F);
        taxiStation.addCarToTaxiStation(sc);

        assertEquals(130.0F,getPriceOfTaxiStation(taxiStation));
    }


    @Test
    public void testStreamGetPriceOfTaxiStation(){
        System.out.println("After test");
        TaxiStation taxiStation = new TaxiStation();
        taxiStation.addCarToTaxiStation(new CargoPassenger());
        Truck truck = new Truck();
        truck.setPrice(42.2F);
        taxiStation.addCarToTaxiStation(truck);
        taxiStation.addCarToTaxiStation(truck);
        taxiStation.addCarToTaxiStation(truck);
        SimpleCar sc = new SimpleCar();
        sc.setPrice(3.4F);
        taxiStation.addCarToTaxiStation(sc);

        float priceOfTaxiStation=StreamGetPriceOfTaxiStation(taxiStation);

        assertEquals(130.0F,priceOfTaxiStation);
    }
    @Test
    @Timeout(value = 2000)
    public void testCountUp(){
        System.out.println("Some test");
        ArrayList<Car>hashSet = new ArrayList<Car>();
        for (int i=0;i<15;i++){
            hashSet.add(new CargoPassenger());
        }
        assertEquals(15,countUp(hashSet));
    }

}

