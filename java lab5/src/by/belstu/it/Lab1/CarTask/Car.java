package by.belstu.it.Lab1.CarTask;

import java.util.Random;

public class Car extends Thread{
    public int idCar;
    public Street street;
    Random random;
    public Car(int carName,Street pStreet)
    {
        idCar=carName;
        street=pStreet;
        random = new Random();
    }

    @Override
    public void run() {
        synchronized (street) {
            boolean flag = random.nextBoolean();
            if(flag){
                street.addCarToFirstDirection(this);
            }else{
                street.addCarToSecondDirection(this);
            }
            System.out.println("Car " + this.getCarsName() + " is on " + (flag?1:2) + " direction");

            try{
                street.wait(1000);
                street.crossTheRoad();
            }catch (InterruptedException ex){
                throw new RuntimeException(ex);
            }
        }
    }
    public int getCarsName(){
        return idCar;
    }
}
