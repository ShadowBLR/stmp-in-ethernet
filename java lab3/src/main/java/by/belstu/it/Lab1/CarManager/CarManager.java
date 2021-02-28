package by.belstu.it.Lab1.CarManager;

import by.belstu.it.Lab1.Car.Car;
import by.belstu.it.Lab1.CarStation.TaxiStation;
import by.belstu.it.Lab1.Interface.Countable;
import by.belstu.it.Lab1.Interface.Sortedable;

import java.util.*;

public class CarManager implements Countable<Car>, Sortedable<Car> {


public Car findCarBySpeed(TaxiStation taxiStation,int minSpeed,int maxSpeed) {
    for (Car car:taxiStation.getListOfCars()) {
        if(car.getMaxSpeed()>=minSpeed&&car.getMaxSpeed()<=maxSpeed){
            return car;
        }
    }
    return null;
}
    @Override
    public int CountUp(List<Car> item) {
    int countOfCarInCarList=0;
        for (Car car:item
             ) {
            countOfCarInCarList++;
        }
        return countOfCarInCarList;
    }
    public float getPriceOfTaxiStation(TaxiStation taxiStation) {
        float totalPrice=0;
        for(Car car :taxiStation.getListOfCars()){
            totalPrice+=car.getPrice();
        }
        return totalPrice;
    }
    @Override
    public List<Car> sort(List<Car> items) {
        Collections.sort(items,new Comparator<Car>() {
            public int compare(Car o1,Car o2){
                return Integer.compare (o1.getFuelConsumption(),o2.getFuelConsumption());
            }
        });
        return items;
        }
    }
