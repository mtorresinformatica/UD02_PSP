/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class ThreadMethodsExample extends Thread {
    
    ThreadMethodsExample (ThreadGroup group, String name) {
        // Call to parent class constructor with group and thread name
        super(group, name);
    }
    
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("["+threadName+"] " + "Inside the thread");
        System.out.println("["+threadName+"] " + "Priority: " 
          + Thread.currentThread().getPriority());
        Thread.yield();
        System.out.println("["+threadName+"] " + "Id: " 
          + Thread.currentThread().getId());
        System.out.println("["+threadName+"] " + "ThreadGroup: " 
          + Thread.currentThread().getThreadGroup().getName());
        System.out.println("["+threadName+"] " + "ThreadGroup count: " 
          + Thread.currentThread().getThreadGroup().activeCount());
    } 
    
    public static void main(String[] args) {
        // main thread 
        Thread.currentThread().setName("Main");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());
        
        ThreadGroup even = new ThreadGroup("Even threads");
        ThreadGroup odd = new ThreadGroup("Odd threads");
        
        Thread localThread = null;
        for (int i=0; i<10; i++) {
            localThread = new ThreadMethodsExample((i%2==0)?even:odd, "Thread"+i);
            localThread.setPriority(i+1);
            localThread.start();
        }
              
        try {
            localThread.join(); // --> Will wait until last thread ends 
                                // like a waitFor() for processes
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            System.err.println("The main thread was interrupted while waiting for " 
              + localThread.toString() + "to finish");
        }
        System.out.println("Main thread ending");
    }    
}