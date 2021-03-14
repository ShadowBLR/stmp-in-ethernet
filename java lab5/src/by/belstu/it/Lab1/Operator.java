package by.belstu.it.Lab1;

public class Operator {
    boolean busy = false;
    private final Object lock;
    private final CallCenter callCenter;

    public Operator(CallCenter callCenter) {
        this.lock = new Object();
        this.callCenter = callCenter;
    }

    public void reply(int id) {
        try {
            System.out.println("Ответ начался");
            System.out.println(id);
            Thread.sleep(100);
            System.out.println("Ответ окончен");
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } finally {
            busy = false;
            callCenter.notifyCallCanter();
        }
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}
