/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javathreads;


public class MyRunnable implements Runnable { // Create MyRunnable class that implements Runnable
    
    public void run(){
        System.out.println("Thread is running.....");
    }
    
    public static void main(String [] args){ // Main method to run the program
    
        MyRunnable myRunnable = new MyRunnable(); // Create MyRunnable object
        Thread t = new Thread(myRunnable); // Create a new thread with myRunnable
        t.start(); // Start the thread
        
    }
}
