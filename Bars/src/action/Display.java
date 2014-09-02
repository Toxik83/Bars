package action;
//Аналогично с клас LoginAction.Razlikata e ,че се създават обекти ,в които се записват 
//данните от таблица .После обектите се записват в ArrayList//

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class Display extends ActionSupport implements ServletRequestAware{
    private static final long serialVersionUID = 1L;
 
    HttpServletRequest request;
 
    public String execute()
    {
 
    try{
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/bars","root","Angel8312194607");
    Statement st=con.createStatement();
    ResultSet rs = st.executeQuery("select * from bar");
 
        List li = null;
        li = new ArrayList();
        Bar bar = null;
 
        while(rs.next())
            {
                bar = new Bar();
 
                bar.setBar_id(rs.getInt("bar_id"));
                bar.setName(rs.getString("name"));
                bar.setPlaces(rs.getInt("places"));          
                bar.setPrice(rs.getInt("price"));
                bar.setTime(rs.getString("time"));
                bar.setAddress( rs.getString("address"));
                li.add(bar);
 
            }
 
        request.setAttribute("display",li);
 
        rs.close();
         st.close();
        con.close();
 
            }
        catch(Exception e){
             e.printStackTrace();
         }
 
            return SUCCESS;
 
    }
 
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
 
    public HttpServletRequest getServletRequest() {
        return request;
}
 
}
