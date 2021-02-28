package by.belstu.it.Lab1;

import by.belstu.it.Lab1.Car.Handler.ConsoleCarHandler;
import by.belstu.it.Lab1.Car.Parser.CarsSaxBuilder;
import by.belstu.it.Lab1.Validation.CarErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.swing.text.html.parser.Parser;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        //Проверка валидации
	    String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
	    String fileName="files/info.xml";
	    String schemaName="files/info.xsd";
        SchemaFactory factory =  SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try{
            //schema creation
            Schema schema = factory.newSchema(schemaLocation);
            //creating a schema-based validator
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            //document check
            validator.setErrorHandler(new CarErrorHandler());
            validator.validate(source);
        } catch (SAXException| IOException e) {
            System.err.println(fileName+" is not correct or valid");
        }

        //Парсинг
        try {
            //SAX parser creating & configuring
            SAXParserFactory SAXfactory = SAXParserFactory.newInstance();
            SAXParser parser =SAXfactory.newSAXParser();
            XMLReader reader=parser.getXMLReader();
            reader.setContentHandler(new ConsoleCarHandler());
            reader.setErrorHandler(new CarErrorHandler());
            reader.parse("files/info.xml");

        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        //generate object from xmlDocument
        CarsSaxBuilder saxBuilder = new CarsSaxBuilder();
        saxBuilder.buildSetCars("files/info.xml");
        System.out.println(saxBuilder.getCars());
    }
}
