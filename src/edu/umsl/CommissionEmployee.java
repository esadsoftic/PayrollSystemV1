/**
 *
 * @author Esad Softic
 */
package edu.umsl;

import java.util.Scanner;

/**
 *
 * @author Esad
 */
public class CommissionEmployee extends Employee
{

    @Override
    public float computeGross()
    {
       
         System.out.println("how many items sold");
         Scanner CE = new Scanner(System.in);
         float input = CE.nextFloat();
         sold = input;
         System.out.println("Enter the unit price of the items you have sold");
         float hold = CE.nextFloat();
         price = hold;
         gross = price * sold;
         gross = .5f * gross;
         return gross;
         
    }
}