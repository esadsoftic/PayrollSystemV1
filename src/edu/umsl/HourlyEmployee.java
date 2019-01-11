package edu.umsl;

import java.util.Scanner;

/**
 *
 * @author Esad Softic
 */
public class HourlyEmployee extends Employee
{

    @Override
   public float computeGross()
        {
            System.out.println("Enter Hours:");
            Scanner HE = new Scanner(System.in);
            float input = HE.nextFloat();
            hours = input;
            System.out.println("Enter rate:");
            float hold= HE.nextFloat();
            rate = hold;
            
            
            if(hours > 40) //overtime
            {
                gross = 40 * rate;
                float overtime = (hours - 40) * (rate * 1.5f);
                gross += overtime;
//                System.out.println("OT Pay is: "+ overtime);
//                System.out.println("Total Pay is: "+ gross);

            }
            else if(hours < 40) //regular
            {
                gross = hours * rate ;
            //    System.out.println("regular Pay is: "+ gross);     
            }
          
            return gross;
            
            
            
        }
   
}
