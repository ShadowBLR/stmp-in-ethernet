package by.belstu.it.Lab1.Car.Handler;

public enum CarXmlTag {
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
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
