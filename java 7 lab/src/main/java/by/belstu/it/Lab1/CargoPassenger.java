package by.belstu.it.Lab1;

public class CargoPassenger extends Car{
    private boolean isCargo;

    public boolean isCargo() {
        return isCargo;
    }

    @Override
    public String toString() {
        return "CargoPassenger{" +
                "Model = "+getModel()+
                " Price = "+getPrice()+
                " FuelConsumption = "+getFuelConsumption()+
                " MaxSpeed = "+getMaxSpeed()+
                " isCargo = " + isCargo +
                '}';
    }

    public void setCargo(boolean cargo) {
        isCargo = cargo;
    }
}
