package by.belstu.it.Lab1.JDBCManager;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
public class JDBCManager {
    Connection Connection;
    Statement Statement;
    String user="";
    String password="";
    String queryFromCreateCities="Create table cities(" +
            "name varchar(30) not null Primary key," +
            "yearOfBirth int not null," +
            "place real not null," +
            "population int not null" +
            ")";
    String queryFromCreatePopilation ="Create table population (" +
            "nameOfCity varchar(30) not null references cities(name)," +
            "nameOfPopulation varchar(30) not null," +
            "language varchar(20) not null" +
            ")";
    String insertIntoCities="INSERT into cities VALUES('Minsk',1067,123.3132,2000000), " +
            "('Grodno',1111,432.423,40000), " +
            "('Brest',1742,4332.23,420000)";
    String insertIntoPopulation="INSERT into population VALUES('Minsk','Кривичи','Белорусский'),"+
	"('Minsk','Славяне','Славянский'),"+
           "('Minsk','Турки','Турецкий'),"+
            "('Brest','Турки','Турецкий'),"+
            "('Brest','Русские','Русский'),"+
            "('Brest','Поляки','Польский'),"+
            "('Grodno','Поляки','Польский'),"+
            "('Grodno','Литвины','Литовский'),"+
            "('Grodno','Славяне','Славянский')";
    public java.sql.Statement getStatement() {
        return Statement;
    }

    public void setStatement(java.sql.Statement statement) {
        Statement = statement;
    }
    public boolean execute(String str) {
        try {
            return Statement.execute(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public JDBCManager(String url, String user, String password){
        try {
            Connection= DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public JDBCManager(String url){
        try {
            Connection= DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Statement createStatement(){
        try {
            return Connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Connection getConnection() {
        return Connection;
    }
    public void setConnection(String url,String user,String password){
        try {
            Connection=DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
