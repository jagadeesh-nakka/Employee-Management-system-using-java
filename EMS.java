import java.util.*;
import java.lang.*;
import java.sql.*;
 class Emp
 {
  String name,gender,course;
  int id,exp;
  float sal;
  static String org="AU";
  Scanner sc = new Scanner(System.in);
//used to read all employee details
  public void read()
   {
	System.out.println("Enter Name:");
 	name=sc.next();
	System.out.println("Enter id:");
 	id=sc.nextInt();
	System.out.println("Enter gender:");
	gender=sc.next();
 	System.out.println("Enter exp:");
   	exp=sc.nextInt();
	System.out.println("Enter course:");
 	course=sc.next();
	System.out.println("Enter salary:");
	sal=sc.nextFloat();
    }
//used to display all employee details
  public void disp()
     {
	int i;
	System.out.println("Name:"+name);
	System.out.println("Id:"+id);
	System.out.println("Gender:"+gender);
	System.out.println("Experience:"+exp);
	System.out.println("Course:"+course);
	System.out.println("Salary:"+sal);
	System.out.println("Org:"+org);
      }
//code for insertion
  public void insert()
     {
	int i;
	System.out.println("\nEnter the following details to ADD list:\n");
	System.out.println("Entername :");
	name= sc.next();
	System.out.println("Enterid :");
	id = sc.nextInt();
	System.out.println("Enter gender :");
	gender= sc.next();
	System.out.println("Enter exp :");
  	exp = sc.nextInt();
        System.out.println("Enter course :");
	course= sc.next();
    	System.out.println("Enter sal :");
	sal = sc.nextFloat();
 
    }
//code for updating employee details
      public void update()
       {
	int choice;
	System.out.println("enter emp id to edit details:");
	id=sc.nextInt();
	System.out.println("\nEDIT Employee Details :\n" +"1)Employee name\n" +"2)id\n" +"3)gender\n" +"4)exp\n" +"5)course\n"+"6)sal\n");
	System.out.println("Enter your choice : ");
	choice=sc.nextInt();
	if(choice==1)
	{
	 System.out.println("\nEnter new Employee name:");
	 name=sc.next();
	}
	else if(choice==2)
	{
	 System.out.println("Enter new Employee id:");
	 id=sc.nextInt();
	}
	else if(choice==3)
	{
	 System.out.println("Enter new Employee gender:");
	 gender=sc.next();
	}
	else if(choice==4)
	{
	 System.out.println("Enter new Employee exp:");
	 exp=sc.nextInt();
	}
	else if(choice==5)
	{
	 System.out.println("Enter new Employee course:");
	 course=sc.next();
	}
	else if(choice==6)
	{
	 System.out.println("Enter new Employee sal:");
	 sal=sc.nextFloat();
	}
	else
	{
	 System.out.println("Enter crct choice");
	}
      }
}
//main method starts here
class EMS
{
  public static void main(String[] args)
    {
	int i,n,k;
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the size");
	n=sc.nextInt();
	Emp x[]=new Emp[n];//x[] is an object created to call class EMP
	
	int option;
	try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jagadeesh", "jagadeesh");
            Statement smt = con.createStatement();
            smt.executeUpdate("create table emp(eid number,ename varchar(20),esal number)");
            System.out.println("table created successfully");
            System.out.println("hii");
            con.close();
        
	do     //loop is used to continue until it is required
	{
  	 System.out.println("1)insertion\n" +"2)deletion\n" +"3)updation\n" +"4)display\n"+"5)search\n"+"6)exit");
  	 System.out.println("enter option to perform");
  	 option=sc.nextInt();
    	 switch(option)
   	 {
          case 1 :
		for(i=0;i<n;i++)
		{
 		 x[i]=new Emp();
 		 x[i].insert();
		Class.forName("oracle.jdbc.driver.OracleDriver");
            //Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jagadeesh", "jagadeesh");
PreparedStatement psmt=con.prepareStatement("insert into emp values(?,?,?,?,?,?)");
psmt.setString(1,name);
psmt.setInt(2,id);
psmt.setString(3,gender);
psmt.setInt(4,exp);
psmt.setString(5,course);
psmt.setFloat(6,sal);
		}
	        break;

          case 2:
		System.out.println("enter id to delete");
		int del=sc.nextInt();
		for(i=0;i<n;i++)
		{
 		 if(x[i].id==del)  //condition to check whether given id and existing id are equal
 		{
  		for(int j=i;j<n-1;j++)   //loop for moving previous reference to present reference
 		{
   		  x[j]=x[j+1];
  		}
                    
 		break;
 		}
 
		}
		n=n-1;  //decreasing size becoz last 2 elements holds same data 
		for(i=0;i<n;i++)   //loop to display the details of remaining employees
		{
		 x[i].disp();
		 System.out.println("\n");
		}
 		break;
	case 3:
		for(i=0;i<1;i++)
		{
 		 x[i].update();
		 break;
		}
		break;

	case 4:

		for(i=0;i<n;i++)
		{
		    x[i].disp();
		    break;
        	}
break;
	case 5:
		System.out.println("enter id to serach the employee details");
		k=sc.nextInt();
  		for(i=0;i<n;i++)
       		 {
		  if((k-1)==i)
		  {
		  x[i].disp();
		  break;
		  }
		  else
		  {
		    System.out.println("invalid input");
		  }
		 }

break;

	case 6:
		System.out.println("code exited");
		System.exit(0);
		break;

	default:
		System.out.println("enter correct operation to be performed");

	}
}while(true);
	 
}
	catch(Exception e) 
	{
            System.out.println(e);
            e.printStackTrace();
        }
   
	
 }
 }