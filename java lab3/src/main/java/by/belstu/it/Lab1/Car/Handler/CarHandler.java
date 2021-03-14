package by.belstu.it.Lab1.Car.Handler;

import by.belstu.it.Lab1.Car.Car;
import by.belstu.it.Lab1.Car.CargoPassenger;
import by.belstu.it.Lab1.Car.SimpleCar;
import by.belstu.it.Lab1.Car.Truck;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CarHandler extends DefaultHandler {
    private Set<Car> cars;
    private Car current;
    private CarXmlTag currentXmlTag;
    private EnumSet<CarXmlTag> withText;
    private static final String ELEMENT_SIMPLE_CAR="SimpleCar";
    private static final String ELEMENT_CARGO_PASSENGER="CargoPassenger";
    private static final String ELEMENT_TRUCK="Truck";
    public CarHandler(){
        cars= new HashSet<>();
        withText=EnumSet.range(CarXmlTag.TRUCK,CarXmlTag.IS_CARGO);
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs){
        switch (qName){
            case ELEMENT_SIMPLE_CAR:
            current=new SimpleCar();
                if(attrs.getLength()==5) {
                    current.setModel(attrs.getValue(1));
                    current.setMaxSpeed(Integer.parseInt(attrs.getValue(2)));
                    current.setCountOfPassengers(Integer.parseInt(attrs.getValue(3)));
                    current.setPrice(Float.parseFloat(attrs.getValue(4)));
                }break;
            case ELEMENT_CARGO_PASSENGER:
                current=new CargoPassenger();
                if(attrs.getLength()==5) {
                    current.setModel(attrs.getValue(1));
                    current.setMaxSpeed(Integer.parseInt(attrs.getValue(2)));
                    current.setCountOfPassengers(Integer.parseInt(attrs.getValue(3)));
                    current.setPrice(Float.parseFloat(attrs.getValue(4)));
                }break;
            case ELEMENT_TRUCK:
                current=new Truck();
            current.setColor(attrs.getValue(0));
            if(attrs.getLength()==5) {
                current.setModel(attrs.getValue(1));
                current.setMaxSpeed(Integer.parseInt(attrs.getValue(2)));
                current.setCountOfPassengers(Integer.parseInt(attrs.getValue(3)));
                current.setPrice(Float.parseFloat(attrs.getValue(4)));
            }break;
                default:
            CarXmlTag temp = CarXmlTag.valueOf(qName.toUpperCase().strip());
            if(withText.contains(temp)){
                currentXmlTag=temp;
            }
        }
    }
    public void endElement(String uri, String localName, String qName){
        if(ELEMENT_SIMPLE_CAR.equals(qName.strip())
        ||ELEMENT_CARGO_PASSENGER.equals(qName.strip())
        ||ELEMENT_TRUCK.equals(qName.strip())){
            cars.add(current);
        }
    }
    public void characters(char[] ch,int start,int length){
        String data = new String(ch,start,length).strip();
        if(currentXmlTag!=null){
            switch (currentXmlTag){
                case COLOR:current.setColor(data);break;
                case MODEL:current.setModel(data);break;
                case PRICE:current.setPrice(Float.parseFloat(data));break;
                case MAX_SPEED:current.setMaxSpeed(Integer.parseInt(data));break;
                case COUNT_OF_PASSENGERS:current.setCountOfPassengers(Integer.parseInt(data));break;
            }
        }
        currentXmlTag=null;
    }
    public Set<Car> getCars(){
        return cars;
    }
}
