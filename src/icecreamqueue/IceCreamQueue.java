/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icecreamqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author CPP_Curriculum
 */
public class IceCreamQueue {

    public static Queue<String> customerQueue = new LinkedList();
    public static Scanner in = new Scanner(System.in);
    public static String customerArrival;
    public static int queueNumber = 0;
    
    public static void main(String[] args) {
        addCustomers();
        Timer timer = new Timer();
        //timed event - first customer in line to be seen, if there are any customers
        timer.schedule(new IceCreamServingTask(), 0, 4000);
    }
    
    public static void addCustomers(){
        for (int i=1; i<5; i++){
            customerQueue.add("Customer " + i);
        }
    }
    
    //inner class to describe the task of serving ice cream to the first customer in a queue
    public static class IceCreamServingTask extends TimerTask{
        
        public void run() {
              
            System.out.println("Sales Assistant is ready to serve the next customer."); 
            if (customerQueue.isEmpty()){
                System.out.println("There are no customers to see.\n");
                System.exit(0);
            }
            else if (customerQueue.size() == 1){
                System.out.println("The customer with ticket number " + customerQueue.poll() + " is getting ice cream");
                System.out.println("There are no more customers to see.\n");
            }
            else{
                System.out.println("The customer with ticket number " + customerQueue.poll() + " is getting ice cream");
                System.out.println("The customers with the following tickets are in the queue: " + customerQueue.toString() + "\n");
            }       
        }
    }
}
