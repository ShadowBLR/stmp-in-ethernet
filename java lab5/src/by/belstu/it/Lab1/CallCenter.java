package by.belstu.it.Lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CallCenter {
    private Object lock;
    List<Operator> operatorList;
    public CallCenter() {
        lock = new Object();
        operatorList = new ArrayList<>();
        operatorList.add(new Operator(this));
        operatorList.add(new Operator(this));
        operatorList.add(new Operator(this));
        operatorList.add(new Operator(this));
        operatorList.add(new Operator(this));
    }

    public void Handle(int id) {

        Operator operator = getOperator(id);
        operator.reply(id);

    }

    public  Operator getOperator(int id){
        synchronized (lock) {
            List<Operator> freeOperators = operatorList.stream()
                    .filter(operator -> !operator.isBusy())
                    .collect(Collectors.toList());

            while (freeOperators.isEmpty()) {
                try {
                    System.out.println(id + " is waiting for");
                    lock.wait();
                    freeOperators = operatorList.stream()
                            .filter(operator -> !operator.isBusy())
                            .collect(Collectors.toList());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            Operator freeOperator = freeOperators.get(0);
            freeOperator.setBusy(true);

            return freeOperator;
        }
    }

    public  void notifyCallCanter(){
        synchronized (lock) {
            System.out.println("Notified");
        lock.notify();
        }
    }

}
