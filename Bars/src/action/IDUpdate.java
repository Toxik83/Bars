package action;
//Аналогично на класа LoginAction.Изпозва обекта Request ,за да извлече стойността на fid
//Парсира го в int (число).Използва тази стойност в заявка Select ,за да върне редове от
//базата с id,съответстващи  на стойноста.Докато ResultSet има редове в него,извлича стойност 
// от базата-данни и я записва в картата под даден ред.След това метода връща "success".
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
 
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
 
import com.opensymphony.xwork2.ActionSupport;
 
public class IDUpdate extends ActionSupport implements ServletRequestAware,ApplicationAware{
    private static final long serialVersionUID = 1L;
 
    HttpServletRequest request;
    Map m;
 
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
 
    public HttpServletRequest getServletRequest() {
        return request;
    }
 
    public void setApplication(Map m)
    {
        this.m=m;
    }   
 
    public String execute()
    {
    try{
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/bars","root","Angel8312194607");
    PreparedStatement ps=null;    
 
        ps=con.prepareStatement("select * from bar where bar_id=?");
        String a = request.getParameter("fid");
        int k = Integer.parseInt(a);
        ps.setInt(1,k);
        //System.out.println("This is" +k);
 
        ResultSet res = ps.executeQuery();
        List l=new ArrayList();
 
        while(res.next())
        {
            m.put("a",res.getInt("bar_id"));
            m.put("b", res.getString("name"));
            m.put("c",res.getInt("places"));
            m.put("d", res.getInt("price"));
            m.put("e", res.getString("time"));
            m.put("f", res.getString("address"));
        }
 
        ps.close();
        con.close();
 
        }
            catch(Exception e){
             e.printStackTrace();
     }
 
            return SUCCESS;
 
    }
 
}
