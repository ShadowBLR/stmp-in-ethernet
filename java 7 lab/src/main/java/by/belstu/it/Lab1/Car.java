package by.belstu.it.Lab1;

public abstract class Car {
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public enum Color {
        RED("orange"),
        ORANGE("orange"),
        YELLOW("yellowe"),
        GREEN("green"),
        BLUE("blue"),
        INDIGO("indigo"),
        BIOLET("biolet"),
        BLACK("black"),
        WHITE("white");
        private String value;

        Color(String value) {
            this.value=value;
        }

        public String getValue() {
            return value;
        }
    }
    private String model;
    private Color color;
    private int maxSpeed;
    private int countOfPassengers;
    private float price;
    private int fuelConsumption;
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(String color){
        this.color=Color.valueOf(color);
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getCountOfPassengers() {
        return countOfPassengers;
    }

    public void setCountOfPassengers(int countOfPassengers) {
        this.countOfPassengers = countOfPassengers;
    }


    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

}
