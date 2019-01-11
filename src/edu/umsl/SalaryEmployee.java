/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.util.Scanner;

/**
 *
 * @author Esad Softic
 */
public class SalaryEmployee extends Employee
{
// public Salary Employee()
// {
//    super("jane", 10, 10); //from employee
// }
    @Override
    public float computeGross()
    {
       System.out.println("Enter if you are S(staff) or E (executive)");
         Scanner CE = new Scanner(System.in);
         String input = CE.next();
//         staff = input;
            if(input.equalsIgnoreCase("S") )
               {
                    gross = 50000;
                    System.out.println("Total pay for staff is:" + gross );
                   //set gross salary to $50,000 for staff
               }
            else 
            if(input.equalsIgnoreCase("E"))
               {
                   gross = 100000;
                   System.out.println("Total pay for executive is:" + gross );
                  //set griss sakary to $100,000 for executives
               }


        
        return gross;
    }

}
