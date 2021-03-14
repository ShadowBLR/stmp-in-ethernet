package by.belstu.it.Lab1.Car;

public class SimpleCar extends Car{
    @Override
    public String toString() {
        return "SimpleCar{" +
                "Model ="+getModel()+
                "Price ="+getPrice()+
                "FuelConsumption ="+getFuelConsumption()+
                "MaxSpeed ="+getMaxSpeed()+
                '}';
    }
}
