import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class FruitShop extends JFrame {
    JPanel p1 = new JPanel ();
    JPanel p2 = new JPanel ();
    
    JLabel l1 = new JLabel ("Display Stock : ");
    
    JButton add = new JButton ("Add new Item");
    JButton delete = new JButton ("Delete Item");
    JButton sell = new JButton ("Sell Items");
    
    private String [] inventory = {"All","Orange","Apple","Banana","Guava","Mango","Papaya","Grapes"};
    
    JComboBox choise = new JComboBox (inventory);
    
    public FruitShop()
    {
    	p1.add (l1);
    	p1.add(choise);
    	
    	p2.add(add);
    	p2.add(delete);
    	p2.add(sell);
    	
    	add(p1, BorderLayout.NORTH);
    	add(p2, BorderLayout.SOUTH);
    	
   }
    public static void main(String[] args) {
    	
    	try
    	{
    		// Loading the SQL Driver 
    		Class.forName ("com.mysql.jdbc.Driver");
    		System.out.println ("Driver Loaded ");
    	}
    	catch(ClassNotFoundException e )
    	{
    		System.out.println ("Driver not load ");
    	}
    	
    		try
    	{
    		Connection con = DriverManager.getConnection ("jdbc:mysql://192.168.100.7/fruitshopdb","saleh","123456");
    		System.out.println("Database Connected ");
    		Statement stm = con.createStatement ();
    		
    	/*	// To delete exesiting table 
    		try
    		{
    			stm.executeUpdate ("drop table 133Fruit");
    			
    		}
    		catch (SQLException e )
    		{
    			System.out.println (e.getMessage());
    		}*/
    		
    		// Create a table and add columns
    		try
    		{
    			stm.executeUpdate("create table 133Fruit (name varchar(100) , qty integer,price double , primary key(name))");
    		}
    		catch(SQLException e)
    		{
    			System.out.println ("table already created ");
    			
    		}
    		
    		//Inserting given inventory 
    		try
    		{
    		
    		stm.executeUpdate("insert into 133Fruit(name, qty , price) values ('Orange','14','5.5')");
    		stm.executeUpdate("insert into 133Fruit(name, qty , price) values ('Apple','27','7')");
    		stm.executeUpdate("insert into 133Fruit(name, qty , price) values ('Banana','20','4.5')");
    		stm.executeUpdate("insert into 133Fruit(name, qty , price) values ('Guava','17','6')");
    		stm.executeUpdate("insert into 133Fruit(name, qty , price) values ('Mango','34','8')");
    		stm.executeUpdate("insert into 133Fruit(name, qty , price) values ('Papaya','16','10')");
    		stm.executeUpdate("insert into 133Fruit(name, qty , price) values ('Grapes','21','6.5')");
    		 
    		 // To Update (Modify) certin data in the data base 
    	//	stm.executeUpdate("update 133Fruit set price='3.5' where name='Lemon'");
    		
    		// To delete items from the data base 
    	//	stm.executeUpdate("delete from 133Fruit where name='Banana'");
    		}
    		catch(SQLException e )
    		{
    			System.out.println (e.getMessage());
    		}
    		
    		// Printing the table contenents
    		try
    		{
    		
    		ResultSet rs = stm.executeQuery("select * from 133Fruit");
    		
    		while (rs.next())
    		{
    			System.out.println (rs.getString (1) + "\t" + rs.getString(2) + "\t" + rs.getString (3) );
    		}
    		}
    		
    		catch(SQLException e)
    		{
    			System.out.println (e.getMessage());
    		}
    	}
    	
    	catch (SQLException e)
    	{
    		System.out.println("Database connection lost ");
    	}
    
    //// End of database section
    
      FruitShop frame = new FruitShop();
        frame.setTitle ("Fruit Shop Inventory System ");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,300);
        frame.setVisible(true);
    }
}

 class ButtonListener implements ActionListener 
{
	public void actionPerformed (ActionEvent e )
	{
		
	}
}
