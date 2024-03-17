package ReadData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import deductions.*;


public class ReturnOption  
{  
	private static String first;
	private static String last;
	private static double total_time = 0;
	private static double total_deductions = 0;
	private static double gross_Salary = 0;
	private static double net_Salary = 0;
	private static BufferedReader buffer_line;
	private static String employee_data = "employee_data.csv";
	private static String time_data = "time.csv";
	private static int max_row = 0;
	
	public static BufferedReader buffer_reader(String file)   
	{  
		try {
			buffer_line = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
        return buffer_line;
	}
	
	public static void enter_details() throws Throwable   
	{  
		@SuppressWarnings("resource")
		Scanner employee = new Scanner (System.in); 
		
		 System.out.println("\n***********************************************");
	     System.out.println("        Employe Payroll Information      ");
	     System.out.println("***********************************************");
	     
	     //ENTER EMPLYEE NAME
	      System.out.println("Enter employee First Name: ");
	      first = employee.nextLine();
	      System.out.println("Enter employee Last Name: ");
	      last = employee.nextLine();  
	      //READ AND DISPLAY EMPLOYEE DATA
	      read_details();
	}
	
	public static void read_details()   
	{  
		String line = ""; 
		int count = 0;
		max_row=0;
		int passFail=0;
			try   
			{  
				//GET MAX ROW
				buffer_reader(employee_data);
				while ((line = buffer_line.readLine()) != null) {
					max_row++;
				}
				//GET EMPLOYEE DETAILS
				buffer_reader(employee_data);
				while ((line = buffer_line.readLine()) != null) 
				{  
					count++;
					if(count != 0) {
						String[] row_data = line.split(","); 
					
						if (row_data[1].equalsIgnoreCase(last) && row_data[2].equalsIgnoreCase(first)) {
									System.out.format("%-20s %5s", "Employee #", row_data[0]+"\n");
									System.out.format("%-20s %5s", "Last Name", row_data[1]+"\n");
									System.out.format("%-20s %5s", "First Name", row_data[2]+"\n");
									System.out.format("%-20s %5s", "SSS #", row_data[3]+"\n");
									System.out.format("%-20s %5s", "Philhealth", row_data[4]+"\n");
									System.out.format("%-20s %5s", "TIN #", row_data[5]+"\n");
									System.out.format("%-20s %5s", "Pag-ibig #", row_data[6]+"\n");
									System.out.format("%-20s %5s", "Basic Salary", row_data[7]+"\n");
									System.out.format("%-20s %5s", "Rice Subsidy", row_data[8]+"\n");
									System.out.format("%-20s %5s", "Phone Allowance", row_data[9]+"\n");
									System.out.format("%-20s %5s", "Clothing Allowance", row_data[10]+"\n");
									System.out.format("%-20s %5s", "Hourly Rate", row_data[11]+"\n");
							break;
						}
						else if (count==max_row && passFail==0) {
							 System.out.println("Employee "+ first +" "+ last + " has no employee information.");
							 break;
						}
						else {
							continue;
						}
						
					}
					
				}  
			}   
		catch (IOException e)   
			{  
					e.printStackTrace();  
			}
	}	
	
	
	public static void work_hour_details() throws Throwable 
	{  
		@SuppressWarnings("resource")
		Scanner employee = new Scanner (System.in); 
		
		 System.out.println("\n***********************************************");
	     System.out.println("        Enter Employee Name   ");
	     System.out.println("***********************************************");
	     
	     //ENTER EMPLYEE NAME
	      System.out.println("Enter employee First Name: ");
	      first = employee.nextLine();
	      System.out.println("Enter employee Last Name: ");
	      last = employee.nextLine();  
	      //READ AND DISPLAY EMPLOYEE DATA
	      calculate_time();
	}
	
	public static void time_diff(String In, String Out) throws Throwable
    { 
  
        String time1 = In; 
        String time2 = Out;
 
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:mm:ss");   
        Date date1 = simpleDateFormat.parse(time1); 
        Date date2 = simpleDateFormat.parse(time2); 
        long differenceInMilliSeconds = Math.abs(date2.getTime() - date1.getTime());
        long differenceInHours = (differenceInMilliSeconds / (60 * 60 * 1000)) % 24;
        long differenceInMinutes = (differenceInMilliSeconds / (60 * 1000)) % 60;
        long differenceInSeconds = (differenceInMilliSeconds / 1000) % 60;
        total_time = (total_time + (differenceInHours + differenceInMinutes/60 + differenceInSeconds/3600)) - 1; 

    } 
	
	public static void calculate_time() throws Throwable   
	{  
		String line = ""; 
		int count = 0;
		max_row=0;
		int passFail =0; 
			try   
			{  
				//GET EMPLOYEE DETAILS
				buffer_reader(time_data);
				while ((line = buffer_line.readLine()) != null) 
				{  
					count++;
					if(count != 0) {
						String[] row_data = line.split(","); 
						
						if (row_data[1].equalsIgnoreCase(last) && row_data[2].equalsIgnoreCase(first)) {
							time_diff(row_data[3],row_data[4]);
						}
						else {
							continue;
						}
					}
					
				} 
				///Get Employee Hour Rate
				line = ""; 
				count = 0;
				//GET MAX ROW
				buffer_reader(employee_data);
				while ((line = buffer_line.readLine()) != null) {
					max_row++;
				}
				//GET EMPLOYEE DETAILS
				buffer_reader(employee_data);
				while ((line = buffer_line.readLine()) != null) 
				{  
					count++;
					if(count != 0) {
						String[] row_data = line.split(","); 
						if (row_data[1].equalsIgnoreCase(last) && row_data[2].equalsIgnoreCase(first)) {
							 System.out.println("\n***********************************************");
						     System.out.println(" Employee Time, Salary & Deduction Computation");
						     System.out.println("***********************************************");
						     System.out.println("First Name: " + row_data[2]);
						     System.out.println("Last Name: " + row_data[1]);
						     System.out.println("Hourly Rate: " + row_data[11]);
						     System.out.println("Total Work Hour Time: " + total_time +" HOURS");
						     
						    //COMPUTE GROSS SALARY
						     gross_Salary = total_time * Double.parseDouble(row_data[11]);
							 System.out.println("Salary On Hours Work (PHP): " + gross_Salary);
							 							 
							 //COMPUTE DEDUCTIONS AND NET SALARY
							 salary_deductions net = new salary_deductions();
							 total_deductions = net.getTotalDeductions(total_time * Double.parseDouble(row_data[11]));
							 System.out.println("Deductions (SSS,Pag-Ibig,PhilHealth): " + total_deductions);
							 net_Salary = gross_Salary - total_deductions;
							 System.out.println("Net Salary: " + net_Salary);
							 passFail=1;
							 
							 
						}
						else if (count==max_row && passFail==0) {
							 System.out.println("Employee "+  first +" "+ last + " has no salary information.");
							 break;
						}
						else {
							continue;
						}
					}
				}
				
				 
			}   
		catch (IOException e)   
			{  
					e.printStackTrace();  
			}
	}	
	
} 

