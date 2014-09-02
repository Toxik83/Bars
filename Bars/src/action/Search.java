package action;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.*;  
import java.util.ArrayList;  
  
public class Search {  
ArrayList<Bar> list=new ArrayList<Bar>();  
  
public ArrayList<Bar> getList() {  
    return list;  
}  
public void setList(ArrayList<Bar> list) {  
    this.list = list;  
}  
public String execute(){  
 try{  
  Class.forName("com.mysql.jdbc.Driver");  
  java.sql.Connection con =DriverManager.getConnection("jdbc:mysql://localhost/bars","root","Angel8312194607");
  java.sql.PreparedStatement ps=con.prepareStatement("select * from bar");  
  ResultSet rs=ps.executeQuery();  
  
  while(rs.next()){  
   Bar bar=new Bar();  
   bar.setName(rs.getString("name"));  
   bar.setPlaces(rs.getInt("places"));  
   bar.setPrice(rs.getInt("price"));
   bar.setTime(rs.getString("time")); 
   bar.setAddress(rs.getString("address"));
   list.add(bar);  
  }  
  
  con.close();  
 }catch(Exception e){e.printStackTrace();}  
          
 return "success";  
}  
}  