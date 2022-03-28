import java.sql.*;	
import java.util.*;

class EMP_salary
{
	public static void main (String args[])
	{
              
		try
		{
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        String servername="127.0.0.1";
                        String portno="1521";
                        String sid="xe";
                        String username="MOHIT_34";
                        String password="Pathak";
                        String url = "jdbc:oracle:thin:@" + servername + ":" + portno + ":" + sid;
                        System.out.println(url);
                          
                          
                        Connection cn = DriverManager.getConnection(url,username,password);
                               Scanner k = new Scanner(System.in);
                               System.out.println("ENTER EmpId");
                                String EmpId = k.next();
 
                           System.out.println("enter FirstName");
                               String FirstName = k.next();
                               System.out.println("ENTER LastName");
                                String LastName = k.next();
                             System.out.println("enter Email");
                               	String Email = k.next();
                              System.out.println("enter PhoneNo");
                                int PhoneNo = k.nextInt();
                               
                                System.out.println("enter Salary");
                                  int Salary = k.nextInt();
                          
             String s = "insert into Employee (EmpId, FirstName, LastName, Email, PhoneNo, Salary) values ("+EmpId+",'"+FirstName+"','"+LastName+"','"+Email+"',"+PhoneNo+","+Salary+")";
                           
                        
			Statement st=cn.createStatement();
                                st.executeQuery(s);
                     ResultSet rs=st.executeQuery("select * from Employee");
			 String Str = "Update into Employee (EmpId, FirstName, LastName, Email, PhoneNo, Salary) values ("+EmpId+",'"+FirstName+"','"+LastName+"','"+Email+"',"+PhoneNo+","+Salary+")";
                        
                     int i=0;
                       
			


                       try
			{               
                                
 
                                while(rs.next())
				{
 
					i++;
					System.out.println("\n["+i+"]---------------");
					System.out.println("ID    = "+rs.getInt("EmpId"));
                                        System.out.println("FIRST NAME  = "+rs.getString("FirstName"));
					System.out.println("LAST NAME = "+rs.getString("LastName"));
                                        System.out.println("Email = "+rs.getString("Email"));
                                        System.out.println("PhoneNo  = "+rs.getInt("PhoneNo"));
	                               System.out.println("SALARY = "+rs.getInt("salary"));
				}
                          
			}
			catch(Exception e)
			{
				System.out.println("Exception : "+e);
			}
                                                      
                                
				st.close();
                             rs.close();
                             cn.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception : "+e);
		}
	}
}
