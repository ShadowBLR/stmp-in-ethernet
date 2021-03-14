package by.belstu.it.Lab1.Car.Writter;

import by.belstu.it.Lab1.Car.Car;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;

public class GsonWrapper<T> {
   Gson gson = new Gson();
   public String  serialize(T car){
        return gson.toJson(car);
   }
   public T deserialize(String serialObject,Type typeOfClass){
        return gson.fromJson(serialObject,typeOfClass);
   }
}
