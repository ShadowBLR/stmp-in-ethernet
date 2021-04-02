package by.belstu.it.Lab1;

public class Truck extends Car {
private float loadCapacity;
private boolean isFull;

    public float getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(float loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public boolean getIsFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
    @Override
    public String toString() {
        return "Truck{" +
                "Model = "+getModel()+
                "Price = "+getPrice()+
                "FuelConsumption = "+getFuelConsumption()+
                "MaxSpeed = "+getMaxSpeed()+
                '}';
    }
}
