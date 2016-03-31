
import java.sql.*;
import java.util.*;

public class SimpleJDBC {
    
    public static void main(String[] args) {
    	try{
        Class.forName("com.mysql.jdbc.Driver"); //Very important you must remember.
        
        Connection con = DriverManager.getConnection("jdbc:mysql://10.31.33.63/testdb", "student", "123456");//("jdbc(protocol):mysql()://Server", "user", "password")
        
        Statement stm = con.createStatement();//to send statment we use stm
        
        Scanner kb = new Scanner(System.in);
        
        /* To chech if the query exist do
         *try
         *{
         	stm.executeUpdate("select * from 372Fruit");
          }
          catch(SQLException e) {
          		stm.executeUpdate("create table 372Fruit (name char(100) primary key, qty integer, price double)");
          	}
          	*/
        try 
        {
        	stm.executeUpdate("drop table 372Fruit"/* or (for primary key), primary key(name)*/);//delete the table if exist
        }
        catch(SQLException e) {
        	System.out.println("Table not deleted.");
        }
        try 
        {
        	stm.executeUpdate("create table 372Fruit (name char(100) primary key, qty integer, price double)"/* or (for primary key), primary key(name)*/);
        
        }
        catch(SQLException e) {
        	System.out.println("Table already created.");
        }
     /* try
        {
        	stm.executeUpdate("insert into 372Fruit values('Banana', '100', '1.25')");//insert these values and you can also add  
        	stm.executeUpdate("insert into 372Fruit values('Orange', '200', '2.5')");//before values (name, qty, price) and the values 
        	stm.executeUpdate("insert into 372Fruit values('Apple', '150', '5')");//or change the ()order and ...
        	
        	stm.executeUpdate("delete from 372Fruit where name = 'Banana'");
        	stm.executeUpdate("update 372Fruit set price = 3.67 where name = 'Apple'");
        	
        }
        catch(SQLException e) {
        	System.out.println(e.getMessage());//get the message from the sql and display it
        	throw e;
        }
        */
        char en = 'a';
        while(en != 'e')
        {
        
        System.out.println("Add the name of the fruit: ");
        	String name = kb.next();
        System.out.println("Add the price of the fruit: ");
        	int qty = kb.nextInt();
        System.out.println("Add the quantity of the fruit: ");
        	double p = kb.nextDouble();
        System.out.println("If you want to end enserting put end to continue put anything else: ");
        		   en = kb.next().charAt(0);
        
        try
        {
        	stm.executeUpdate("insert into 372Fruit values('" + name +"', '" + qty + "', '" + p + "')");
        	
        }
        catch(SQLException e)
        {
        	System.out.println(e.getMessage());
        }
        }
        
        ResultSet rs = stm.executeQuery("select * from 372Fruit");//ResultSet will take the Sql output and put it in the rs
        
        while(rs.next()) 
        {
        	System.out.println(rs.getInt(2) + "\t" + rs.getString(1) + "\t" + rs.getDouble(3));//the number are for column
        }
        
        con.close();//to closethe connection
 		
        }
        
        catch(ClassNotFoundException e){
        	System.out.println("Class not found.");
        }
        catch(SQLException e) {
        	System.out.println("Connection refused.");
        }
        
    }
}
