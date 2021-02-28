package by.belstu.it.Lab1.Validation;
import java.lang.String;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarErrorHandler implements ErrorHandler {
    private static Logger Logger = LoggerFactory.getLogger(CarErrorHandler.class);
    public  String getLineColumnNumber(SAXParseException e){
        return e.getLineNumber()+" : "+e.getColumnNumber();
    }

    public void warning(SAXParseException e){
        Logger.warn(getLineColumnNumber(e)+"-"+e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        Logger.error(getLineColumnNumber(e)+" - "+e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        Logger.error(getLineColumnNumber(e)+" - "+e.getMessage());
    }
}
