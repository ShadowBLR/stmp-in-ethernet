package by.belstu.it.Lab1.CarStation;

import by.belstu.it.Lab1.Car.Car;

import java.util.ArrayList;
import java.util.List;

public class TaxiStation {
    private ArrayList<Car> listOfCars;
    public TaxiStation(){
        listOfCars = new ArrayList<Car>();
    }

    public List<Car> getListOfCars() {
        return listOfCars;
    }

    public void setListOfCars(ArrayList<Car> listOfCars) {
        this.listOfCars = listOfCars;
    }
    public boolean addCarToTaxiStation(Car car) {
        return listOfCars.add(car);
    }
       public Car removeCarFromTaxiStation(int index){
          return  getListOfCars().remove(index);
        }
        public boolean removeCarFromTaxiStation(Car car){
            return getListOfCars().remove(car);
    }
}
