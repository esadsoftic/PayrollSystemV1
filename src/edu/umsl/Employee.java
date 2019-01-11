package edu.umsl;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Esad Softic
 */
public class Employee implements Serializable
{
    /*********************
         Attributes
    *********************/
    float rate=0f;
    float taxrate=0.2f;
    float hours=0;
    float gross=0.0f;
    float tax=0.0f;
    float net=0.0f;
    float net_percent=0.0f;   
    String first_Name;
    String HoursWorked;
    String staff;
    String executive;
    float sold;
    float price;
//    String first_Name;
    public static int counter;    
//        Scanner sc = new Scanner(System.in);
//        String input = sc.next(); 
        //private String Hours;
    //End Attributes
        /********************
         Constructors
    ********************/
        public Employee()
        {
            first_Name = "josh";
            hours = 0;
            rate = 0f; 
            counter++;  
        }
        
        public Employee(String first_Name, float HR, float HW) //floats instead of ints
        {
            String ex = null;
            String st = null;
            executive = ex;
            staff = st;
            rate = HR;
            hours = HW;

        }
        public String getfirst_Name()
        {
            return first_Name;
        }
        public void setfirst_Name(String fn)
        {
            first_Name = fn;
        }
        public void setHours(float r1)
        {
            hours = r1;
        }
        public void setRate(float r2)
        {
            rate = r2;
        }
    /********************
         Methods
    ********************/
    protected void computeTax() 
        { 
            tax=gross*taxrate;
        }

    protected void computeNet()
        { 
            net=gross-tax;
        }

    protected void computeNetperc() 
    { 
         net_percent=(net/gross)*100;
    }

    protected float computeGross()
    { 
    //float hours;??
         gross=rate*hours;
         return gross;
    }

    public void calculateAll()
    {
       System.out.println("Im going to calculate " + first_Name);
       computeGross();
       computeTax();
       computeNet();
       computeNetperc();
       displayEmployee();
    }
    
    public void displayEmployee() 
    {
        System.out.println("Name: " + new String(first_Name));        
        System.out.println("Hours: " + new Float(hours));
        System.out.println("Rate: " + new Float(rate));
        System.out.println("Gross: " + new Float(gross));
        System.out.println("Net: " + new Float(net));
        System.out.println("Net%: " + new Float(net_percent) + "%");
    }
}