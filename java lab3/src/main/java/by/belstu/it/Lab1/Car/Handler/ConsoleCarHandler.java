package by.belstu.it.Lab1.Car.Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ConsoleCarHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started");
    }

    /**
     * @param uri уникальное название Namespace
     *            localName - имя элемента без префикса, задаваемого атрибутом xmlns
     *            qName - полное имя элемента с префиксом
     *            attrs - список атрибутов
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs){
        String tagData = qName+" ";
        for (int i = 0; i < attrs.getLength(); i++) {
            tagData+=" "+attrs.getQName(i)+"="+attrs.getValue(i);
        }
        System.out.println(tagData);
    }
    @Override
    public  void characters(char[] ch,int start,int length){
        System.out.println(new String(ch,start,length));
    }
    @Override
    public  void  endElement(String uri,String localName,String qName){
        System.out.println(" "+qName);
    }
    @Override
    public void endDocument(){
        System.out.println("\nParsing ended");
    }
}
