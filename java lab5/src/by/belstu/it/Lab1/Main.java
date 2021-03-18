package by.belstu.it.Lab1;

import by.belstu.it.Lab1.CarTask.Car;
import by.belstu.it.Lab1.CarTask.Street;

public class Main {

    public static void main(String[] args) {
	CallCenter callCenter = new CallCenter();
        for(int i=0;i<50;i++) {
            new Thread(new Consumer(callCenter,i)).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Street street = new Street(2,20);

        for (int i = 0; i < 20; i++) {
            (new Car(i+1, street)).start();
            try {
                Thread.sleep(100);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
