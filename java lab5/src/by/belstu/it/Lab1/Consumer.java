package by.belstu.it.Lab1;

public class Consumer implements Runnable{
   private  CallCenter Center;
   private int id;
    public  void Call(CallCenter callCenter)
    {

        callCenter.Handle(id);

    }
public Consumer(CallCenter center,int _id){
    this.Center=center;
    id=_id;
}
    @Override
    public void run() {
        Call(Center);
    }
}
