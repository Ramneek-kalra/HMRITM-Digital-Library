
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ramneek Kalra
 */
public class connect {
    Connection con1;
    public void cona(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con1=(Connection)
            DriverManager.getConnection("jdbc:mysql://172.16.31.51:3306/library","root","HMRITM");}
        catch(Exception e){System.out.println(e);}
    }
}
