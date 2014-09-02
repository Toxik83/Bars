package action;
//Action -��������� ��������� ������������ �� ����������  �������� � ������ ��.//
//�� �� ��������� ����.� ������ ����� ��������  ����������, �� �� ��������� ���������� �� ,� 
//������ ActionSupport � SessionAware.������� ��������� ������ �� HTTP �����  �� ����������.//
//����  ����  �� ���� ������ �� ����� (Map),� ����� ����� ��  �� ������ ������ ,�����
// ��  ��  ��������� ��-�����//
//������ �������� � JDBC � SQL//
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
// ���� ����� ����������� ������ � ������-�����.�����  �������� SQl , �� �� ���������� 
//������� � ������-�����.� ������  �������� Select ������.
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
 //������  �� �� PreparedStatement �� ����� � ������ ������ ,����  ��  ��������� username 
// � password , �������� �� ��������.������� ,�� ����� �� �� ����� , ��  �������  ���� 
// ��������� ��� ���   ��� ������ ps.setString.� ������ ����� � �������� �� ������ � �� 
 //  �������� setString//
         
         ps.setString(1, username);
         ps.setString(2, password);
 //���������� ��  ��������  ��  ������� � ResultSet.����������  ��  ������ �� ������� ���
         //������� �� ������ -�����//
         
         ResultSet rs = ps.executeQuery();

         String role=null;
 //���������  ���� ResultSet ��� ��� ������//
         if (rs.next()) {       	
 //������� ��������� � ��������  �� ����//
             role = rs.getString("role");
             System.out.println(role);
 //��� ��������� � �dmin,���������  �  ������� ���� ���� "username" � ���� �������� 
 // ����� �� �����������.����� ������ ����� ��� "success".Struts.xml ����� �� ���� ��������
 // ��  ��� ��������  ������ ��  ���� � �� ��������//
             if("admin".equalsIgnoreCase(role)){
             	session.put("username",getUsername());
             	  return "success";
             }
 //���������� � �����//
             else if("user".equalsIgnoreCase(role)){
             	session.put("username",getUsername());
             	return "error";
             }
         }
  //���� ��� �������� ���������� ������ � �� ���������//
      } catch (Exception e) {
    	  System.out.println(e);
      } finally {
         if (conn != null) {
            try {
 //���������  �������� ,��  ��  ��  ��  ����� �������//
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
//����  �  ���  ��  ����������.��� ������������ ��  � ����� �������� � ������ ���� ��� 
// ������� ,��  �������  ��������� , �� �� �������//
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
