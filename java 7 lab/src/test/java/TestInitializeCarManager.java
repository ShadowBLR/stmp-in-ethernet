import by.belstu.it.Lab1.Car;
import by.belstu.it.Lab1.CarManager.CarManager;
import by.belstu.it.Lab1.CarStation.TaxiStation;
import by.belstu.it.Lab1.Truck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInitializeCarManager {
    @Test
    public void testStreamFindCarBySpeed(){

        TaxiStation ts= new TaxiStation();
        Truck tr = new Truck();
        tr.setMaxSpeed(43);
        Truck tr2 = new Truck();
        tr2.setMaxSpeed(2);
        Truck tr3 = new Truck();
        tr3.setMaxSpeed(77);
        ts.addCarToTaxiStation(tr);
        ts.addCarToTaxiStation(tr2);
        ts.addCarToTaxiStation(tr3);
        CarManager cm= new CarManager();
        Car cr =cm.StreamFindCarBySpeed(ts,0,50);

        int maxSpeed = cr.getMaxSpeed();

        assertEquals(43,maxSpeed);


    }
}
