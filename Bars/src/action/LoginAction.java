package action;
//Action -класовете отговарят изпълнението на определено  действие и изхода му.//
//Те са обикновен клас.В случая класа използва  интерфейси, за да реализира действието си ,а 
//именно ActionSupport и SessionAware.Вторият позволява достъп до HTTP сесия  на потребител.//
//След  това  те имат достъп до карта (Map),в която могат да  се слагат обекти ,които
// да  се  използват по-късно//
//Класът използва и JDBC и SQL//
import java.util.Map;  
import java.sql.*;

import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	private String username,password;  
	private SessionMap<String,Object> session;
	
public SessionMap<String, Object> getSession() {
		return session;
	}
// Този метод осъществява връзка с базата-данни.После  използва SQl , за да манипулира 
//данните в базата-данни.В случая  използва Select заявка.
public String execute(){
	 String ret = "ERROR";
     Connection conn = null;

     try {
         String URL = "jdbc:mysql://localhost/bars";
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(URL, "root", "Angel8312194607");
         String sql = "SELECT role,username FROM user JOIN roles ON user.roles_id=roles.role_id WHERE";
         sql+=" username = ? AND password = ?";
         PreparedStatement ps = conn.prepareStatement(sql);
 //Задава  се на PreparedStatement да търси в базата редове ,като  се  използват username 
// и password , подадени от страница.Данните ,по които ще се търси , се  задават  като 
// аргументи под ред   към метода ps.setString.В случая името и паролата са низове и се 
 //  използва setString//
         
         ps.setString(1, username);
         ps.setString(2, password);
 //Резултатът от  заявката  се  записва в ResultSet.Резултатът  са  редове от таблица или
         //таблици от базата -данни//
         
         ResultSet rs = ps.executeQuery();

         String role=null;
 //Проверява  дали ResultSet има още редове//
         if (rs.next()) {       	
 //извлича стойноста в колоната  на реда//
             role = rs.getString("role");
             System.out.println(role);
 //Ако стойноста е аdmin,записваме  в  сесията като ключ "username" и като стойност 
 // името на потребителя.После класът връща низ "success".Struts.xml вижда за тази стойност
 // на  коя страница  трябва да  идем и ни препраща//
             if("admin".equalsIgnoreCase(role)){
             	session.put("username",getUsername());
             	  return "success";
             }
 //Аналогично с админ//
             else if("user".equalsIgnoreCase(role)){
             	session.put("username",getUsername());
             	return "error";
             }
         }
  //Този код прихваща възникнали грешки и ги отпечатва//
      } catch (Exception e) {
    	  System.out.println(e);
      } finally {
         if (conn != null) {
            try {
 //Затваряме  връзката ,за  да  не  се  хабят ресурси//
               conn.close();
            } catch (Exception e) {
            }
         }
      }
      return ret;
   }
public String logout(){  
    if(session!=null){  
        session.remove("username");
    }  
    return "success";  
}  
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> map) {
	session= (SessionMap<String, Object>) map;
		
	}
//Това  е  код  за  валидиране.Ако потребителят не  е подал стойност в дадено поле във 
// формата ,се  изписва  съобщение , че се изисква//
	 public void validate()
	   {
	      if (username == null || username.trim().equals(""))
	      {
	         addFieldError("username","The username is required");
	      }
	      if (password ==null)
	      {
	         addFieldError("password","Password is required");
	      }
	   }
}
