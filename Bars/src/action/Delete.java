package action;
//Аналогично с клас LoginAction ,но с различна функция.От обекта Request се вижда кои 
//номера  са отбелязани и се обхождат в масив.За всяка стойност в масива се използва заявка 
//Delete и се изтрива реда с id,съответстващ на стойноста в масива.После класът връща низ
//success.

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class Delete extends ActionSupport implements ServletRequestAware{    
    private static final long serialVersionUID = 1L;
 
    HttpServletRequest request;        
 
    public String execute()
    {            
 
    try{
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/bars","root","Angel8312194607");
    PreparedStatement ps=null;
 
    String cv[]=request.getParameterValues("rowdelete");
 
    for(int i=0;i<cv.length;i++)
    {
        ps=con.prepareStatement("delete from bar where bar_id=(?)");
        int k = Integer.parseInt(cv[i]);
        System.out.println("this is" +k);
        ps.setInt(1,k);        
        ps.executeUpdate();
        
    }    
 
        ps.close();          
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
