package by.belstu.it.Lab1;

import by.belstu.it.Lab1.JDBCManager.JDBCManager;

import javax.xml.transform.Result;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection Connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
        Statement statement = Connection.createStatement();

        ResultSet res1=statement.executeQuery("SELECT * FROM cities INNER JOIN population on cities.name=population.nameOfCity where cities.name='Grodno' and population.language='Польский'");
        while(res1!=null&& res1.next()){
            System.out.println("Имя:"+res1.getString("name"));
            System.out.println("Год основания:"+res1.getInt("yearOfBirth"));
            System.out.println("Язык:"+res1.getString("language"));
            System.out.println("Население:"+res1.getString("nameOfPopulation"));
            System.out.println("---------------------------------------------------");
        }

        PreparedStatement preparedStatement= Connection.prepareStatement("SELECT * FROM cities  ORDER by cities.yearOfBirth  LIMIT ?");
        preparedStatement.setInt(1,1);
        ResultSet res2=preparedStatement.executeQuery();
        while(res2!=null&& res2.next()){
            System.out.println("Имя:"+res2.getString("name"));
            System.out.println("Год основания:"+res2.getInt("yearOfBirth"));
            System.out.println("Площадь:"+res2.getFloat("place"));
            System.out.println("Население:"+res2.getInt("population"));
            System.out.println("---------------------------------------------------");
        }
        Connection.setAutoCommit(false);
        Savepoint spt = Connection.setSavepoint("svpt1");
    try{
        Statement stm = Connection.createStatement();
        stm.executeQuery("UPDATE cities set population=0");
        Statement stm2 = Connection.createStatement();
        stm2.executeQuery("Error query");
        Connection.commit();
    }catch(Exception ex){
        System.out.println("Rollback");
        System.out.println("-----------------------------------------");
        Connection.rollback(spt);
        Connection.setAutoCommit(true);
        }
       finally {
        Connection.setAutoCommit(true);
        ResultSet res3=statement.executeQuery("SELECT * FROM cities  ORDER by cities.yearOfBirth  LIMIT 1");
        while(res3!=null&& res3.next()){
            System.out.println("Имя:"+res3.getString("name"));
            System.out.println("Год основания:"+res3.getInt("yearOfBirth"));
            System.out.println("Площадь:"+res3.getFloat("place"));
            System.out.println("Население:"+res3.getInt("population"));
            System.out.println("---------------------------------------------------");
        }
    }



       /* MyManager.setStatement(MyManager.createStatement());
        ResultSet result1 = MyManager.getStatement().executeQuery("SELECT * FROM cities INNER JOIN population on cities.name=population.nameOfCity where cities.name='Grodno' and population.language='Польский'");
       var result2 =  MyManager.getStatement().execute("SELECT * FROM cities INNER JOIN population on cities.name=population.nameOfCity\n"+
        "where population.nameOfPopulation='Славяне'");
        var result3 =MyManager.getStatement().execute("SELECT * FROM cities inner JOIN population on cities.name=population.nameOfCity\n" +
                "\tWHERE cities.population=2000000");

        PreparedStatement preparedStatement =MyManager.getConnection().prepareStatement("SELECT * FROM cities " +
                " ORDER by cities.yearOfBirth  " +
                "    LIMIT ?");
        preparedStatement.setInt(1,1);
        ResultSet resultSet= preparedStatement.executeQuery();
        while(result1.next()){
            String name = result1.getString("name");
            int pop = result1.getInt("population");
            System.out.println(name);
            System.out.println(pop);
        }*/
       // System.out.println(resultSet.getString("name"));
    }
}
