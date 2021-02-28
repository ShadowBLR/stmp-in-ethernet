package by.belstu.it.Lab1.Car.Handler;

public enum CarXmlTag {
    TRUCK("Truck"),
    CARGO_PASSENGER("CargoPassenger"),
    SIMPLE_CAR("SimpleCar"),
    CAR("car"),
    MODEL("model"),
    COLOR("color"),
    MAX_SPEED("maxSpeed"),
    COUNT_OF_PASSENGERS("countOfPassengers"),
    PRICE("price"),
    FUEL_CONSUMPTION("fuelConsumption"),
    LOAD_CAPACITY("loadCapacity"),
    IS_FULL("isFull"),
    IS_CARGO("isCargo");

private String value;
    CarXmlTag(String value) {
        this.value = value.strip();
    }
    public String getValue(){
        return value;
    }
}
