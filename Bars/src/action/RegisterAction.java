package action;

import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
    private static final long serialVersionUID = 1L;
 
    User user =new User();    
 
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
 
    public String execute()
    {
 
    try{
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/bars","root","Angel8312194607");
 
    String s = "insert into User(Username,Password) values(?,?)";
    PreparedStatement ps=(PreparedStatement) con.prepareStatement(s);
    ps.setString(1,user.getUsername());
    ps.setString(2, user.getPassword());
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