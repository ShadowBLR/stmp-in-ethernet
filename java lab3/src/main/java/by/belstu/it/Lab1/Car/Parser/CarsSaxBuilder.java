package by.belstu.it.Lab1.Car.Parser;

import by.belstu.it.Lab1.Car.Car;
import by.belstu.it.Lab1.Car.Handler.CarHandler;
import by.belstu.it.Lab1.Validation.CarErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class CarsSaxBuilder {
    private Set<Car> cars;
    private CarHandler handler = new CarHandler();
    private XMLReader reader;
    public CarsSaxBuilder(){
        //reader configuration
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        assert reader != null;
        reader.setErrorHandler(new CarErrorHandler());
        reader.setContentHandler(handler);
    }
    public Set<Car> getCars(){
        return cars;
    }
    public void buildSetCars(String filename){
        try{
            reader.parse(filename);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        cars = handler.getCars();
    }

}
