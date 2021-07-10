package lib_my;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
	public  Connection connection;
    public Statement statement;
    private  String StrUrl="jdbc:mysql://localhost:3306/dbms_project";
    private  String StrUid="root";
    private  String StrPwd= "";
   public conn(){  
       try{  
       	//System.out.println("debug 1");
           Class.forName("com.mysql.jdbc.Driver").newInstance();  
           //System.out.println("debug 2");
           //this.connection =DriverManager.getConnection("jdbc:mysql:///ums","root",""); 
           this.connection =DriverManager.getConnection(StrUrl,StrUid,StrPwd); 
           this.statement =connection.createStatement();  
           //System.out.println("debug 3");
           
          
       }catch(Exception e){ 
           System.out.println(e);
       }  
   }  

}
