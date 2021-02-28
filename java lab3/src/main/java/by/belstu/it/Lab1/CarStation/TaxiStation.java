package by.belstu.it.Lab1.CarStation;

import by.belstu.it.Lab1.Car.Car;

import java.util.List;

public class TaxiStation {
    private List<Car> listOfCars;

    public List<Car> getListOfCars() {
        return listOfCars;
    }

    public void setListOfCars(List<Car> listOfCars) {
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
