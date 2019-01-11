package edu.umsl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.nio.file.Files.size;
import java.util.Scanner;

/**
 *
 * @author Esad Softic
 */
public class Payroll 
{
    Employee[] emarray = new Employee[2];
    boolean loadEmployeeData = false;
     
    public static void main(String[] args) throws IOException
      {
        Employee em = new Employee();
   
        em = new HourlyEmployee();
        em = new SalaryEmployee();      
        em = new CommissionEmployee();
        
        Payroll pa = new Payroll();
        pa.topMenu();
        pa.saveEmployee();
        
      }
    private Employee[] employeeList;

    public void topMenu() throws IOException
      {
        Scanner sc = new Scanner(System.in);
        
            int input;
            do
            {
               System.out.println("0) Load Employee Data from file");
               System.out.println("1) Populate Employee Data");
               System.out.println("2) Lookup Employee by Name");
               System.out.println("3) Exit");
               input = sc.nextInt();
                if(input == 0)
                {
                    loadEmployee();                   
                }
                else
                    if(input == 1)
                    {
                        populateEmployee();
                      
                    }
                    else
                        if(input == 2)
                        {
                            selectEmployee();
                            saveEmployee();
                        }
                        else 
                            if(input == 3)
                            {
                                System.exit(0);
                            }
                }while(input !=3);            
      }
    public void populateEmployee()
      {
         if  (loadEmployeeData)
        {
            System.out.println("You've already loaded account");
        }
        else
        {   
       //     String id_holdinput;
            Scanner sc = new Scanner(System.in);
            for(int i=0; i<emarray.length; i++)
            {
                    System.out.println("Please enter if you are HE, SE, or CE");
                    System.out.println("HE = Hourly Employee");
                    System.out.println("SE = Salary Employee");
                    System.out.println("CE = Commission Employee");
                    String input = sc.next();
                    
                    if(input.equalsIgnoreCase("HE"))
                    {
                        emarray[i] = new HourlyEmployee();
                        System.out.println("Please enter your first name");
                        String first_Name = sc.next();
                        emarray[i].setfirst_Name(first_Name);
                    }
                    else if(input.equalsIgnoreCase("SE"))
                    {
                        emarray[i] = new SalaryEmployee();
                        System.out.println("Please enter your first name");
                        String first_Name = sc.next();
                        emarray[i].setfirst_Name(first_Name);
                    }

                    else if(input.equalsIgnoreCase("CE"))
                    {
                        emarray[i] = new CommissionEmployee();        
                        System.out.println("Please enter your first name");
                        String first_Name = sc.next();
                        emarray[i].setfirst_Name(first_Name);
                    }
                    else 
                    {
                        System.out.println("not valid option, SE, CE, or HE wasn't put in");
                        populateEmployee();  
                    }
            }                       
         loadEmployeeData=true;
      }
    }
    
    public void selectEmployee()
      {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter first name to lookup:");
        String secondinput = sc.next();
        int index = -1;

        for(int i=0; i<emarray.length; i++)
        {
            if(emarray[i].getfirst_Name().equalsIgnoreCase(secondinput))
            {
                index = i;
            }   
        }
        if(index == -1)
        {
            System.out.println("didn't find your record, check name");
        }
        else
        {
            emarray[index].calculateAll();
        } 
      } 

    public void saveEmployee() throws IOException
    {
        try
        {
            FileOutputStream outStream = new FileOutputStream("file1.txt");
            ObjectOutputStream os = new ObjectOutputStream(outStream);
        //    Object employeeList = null;
            os.writeObject(emarray);
            os.flush();
            os.close();
        
            
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        
       
    }

     public void loadEmployee()

    {    
        try
        {
            FileInputStream inStream = new FileInputStream("file1.txt");
            ObjectInputStream is = new ObjectInputStream(inStream);
            emarray = (Employee[]) is.readObject();  
            is.close();
            for(int i = 0; i < emarray.length; i++)
                
            {  
                emarray[i].displayEmployee();
            }
            
            
        }
        catch (Exception e)
        {
         System.err.println(e);
        }
    }
        
     public void writeAcct()
    {
        int size = 0;
        for (int i=0; i<size; i++) 
        {
           try 
        {
            File file = new File("employeeINFO.txt");

             if (!file.exists()) 
             {
                     file.createNewFile();
             }
             FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);

             String tempString = emarray[i].first_Name;
             float gross = emarray[i].gross;
             float net = emarray[i].net;
             float netPerc = emarray[i].net_percent;
             float tax = emarray[i].tax;

             String name = "Employee: ";
             bw.write(name);
             bw.write(tempString);
             bw.newLine();
             String showGross = "Gross: ";
             bw.write(showGross);
             bw.write(Float.toString(gross));
             bw.newLine();
             String showNet = "Net: ";
             bw.write(showNet);
             bw.write(Float.toString(net));
             bw.newLine();
             String showNetPerc = "Net Percent: ";
             bw.write(showNetPerc);
             bw.write(Float.toString(netPerc));
             bw.newLine();
             String showTax = "Tax: ";
             bw.write(showTax);
             bw.write(Float.toString(tax));
             bw.newLine();
             bw.newLine();
             bw.close();
        } 
        catch (IOException e)
        {
             e.printStackTrace(); 
        }
    }
}
}
