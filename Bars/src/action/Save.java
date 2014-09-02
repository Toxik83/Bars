package action;

import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;

public class Save extends ActionSupport{
    private static final long serialVersionUID = 1L;
 
    Bar bar =new Bar();    
 
    public Bar getBar() {
        return bar;
    }
    public void setBar(Bar bar) {
        this.bar = bar;
    }
 
    public String execute()
    {
 
    try{
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/bars","root","Angel8312194607");
 
    String s = "insert into Bar(NAME,PLACES,PRICE,TIME,ADDRESS) values(?,?,?,?,?)";
    PreparedStatement ps=(PreparedStatement) con.prepareStatement(s);
    ps.setString(1, bar.getName());
    ps.setInt(2, bar.getPlaces());
    ps.setInt(3,bar.getPrice());
    ps.setString(4,bar.getTime());
    ps.setString(5,bar.getAddress());
    ps.executeUpdate();
    
 
        ps.close();
        con.close();
 
            }
        catch(Exception e){
             e.printStackTrace();
         }
 
            return SUCCESS;
 
    }
 
}