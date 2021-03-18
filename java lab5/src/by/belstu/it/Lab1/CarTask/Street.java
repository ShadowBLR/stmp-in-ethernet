package by.belstu.it.Lab1.CarTask;

import java.util.ArrayDeque;

public class Street {
    private ArrayDeque<Car> firstDirection;
    private ArrayDeque<Car> secondDirection;
    public int streetSize;
    static int countOfCars=0;
    static boolean selectDirection;

    public Street(int size,int count){
streetSize=size;
firstDirection=new ArrayDeque<>(count);
secondDirection=new ArrayDeque<>(count);
    }
    public synchronized void driveArray(){
        Car car=null;
        car =getCar(selectDirection);
        if(car==null){
            System.out.println("\nDon't have auto");
        }else{
            System.out.println(car.getCarsName()+"is left");
            countOfCars++;
        }
    }
    public synchronized void crossTheRoad(){
        showStreet();
        if(countOfCars>=streetSize||checkDirection(selectDirection)&&!checkDirection(!selectDirection)){
            selectDirection=!selectDirection;
            countOfCars=0;
        }
        System.out.println("count"+countOfCars+", direction "+(selectDirection?1:2));
        driveArray();
    }
    public  synchronized Car getCar(boolean flag){
        if(flag){
            return getCarFromFirstDirection();
        }else{
            return getCarFromSecondDirection();
        }
    }

    public synchronized boolean checkDirection(boolean flag) {
        if(flag) {
            return checkCarInFirstDirection();
        } else {
            return checkCarInSecondDirection();
        }
    }
    public synchronized void addCarToFirstDirection(Car car) {
        firstDirection.addLast(car);
    }

    public synchronized void addCarToSecondDirection(Car car) {
        this.secondDirection.addLast(car);
    }

    public synchronized Car getCarFromFirstDirection() {
        if (!this.checkCarInFirstDirection()) {
            return this.firstDirection.pollFirst();
        } else {
            return null;
        }
    }
    public synchronized Car getCarFromSecondDirection()
    {
        if (!this.checkCarInSecondDirection()) {
            return secondDirection.pollFirst();
        } else {
            return null;
        }
    }

    public synchronized boolean checkCarInFirstDirection() {
        return firstDirection.isEmpty();
    }

    public synchronized boolean checkCarInSecondDirection() {
        return secondDirection.isEmpty();
    }

    public synchronized void showStreet() {
        System.out.print("Street places:\nFirst Direction { ");
        for (Car c: firstDirection) {
            System.out.print(c.getCarsName()+" ");
        }
        System.out.print("};\nSecond Direction { ");
        for (Car c: secondDirection) {
            System.out.print(c.getCarsName()+" ");
        }
        System.out.println("}");
    }
}
