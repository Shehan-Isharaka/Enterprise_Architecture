/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javathreads;


public class MyThread extends Thread { // MyThread class that extends Thread
    
    public void run(){ // Override run method
        System.out.println("Thread is running...");  // Print message when thread runs    
    }
    
    public static void main(String [] args){
        
        MyThread t = new MyThread();// Create a new MyThread object
        t.start();  // Start the thread (calls run() method)
        
    }
}
