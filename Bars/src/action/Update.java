package action;
//Аналогично на LoginAction.Използва JDBC и SQl , за да промени данните в базата.
//Взима стойностите в картата от класа IDUpdate и ги променя .
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
import com.opensymphony.xwork2.ActionSupport;
public class Update extends ActionSupport{
    private static final long serialVersionUID = 1L;
 
    Bar bar=new Bar();    
 
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
 
    String s = "update bar set name=?,places=?,price=?,time=?,address=? where bar_id=?";
    PreparedStatement ps=con.prepareStatement(s);
    ps.setString(1, bar.getName());
    ps.setInt(2, bar.getPlaces());
    ps.setInt(3, bar.getPrice());
    ps.setString(4, bar.getTime());
    ps.setString(5, bar.getAddress());
    ps.setInt(6, bar.getBar_id());
    ps.executeUpdate();
    con.commit();
 
        ps.close();
        con.close();
 
            }
        catch(Exception e){
             e.printStackTrace();
         }
 
            return SUCCESS;
 
    }
 
}
