package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dbcon {
    Connection connection;
    Statement statement;

    public dbcon(){
        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem" , "root" ,"");
            statement = connection.createStatement();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
