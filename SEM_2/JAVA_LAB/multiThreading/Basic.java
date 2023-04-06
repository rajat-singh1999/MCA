
class MultiThreading extends Thread {
    public void run(){
        System.out.println("Thread" + Thread.currentThread().threadId()+" is running.");
    }
}

class MultithreadingDemo implements Runnable {
    public void run()
    {
        try {
            System.out.println(
                "Thread " + Thread.currentThread().threadId() + " is running");
        }
        catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}

public class Basic{
    public static void main(String args[]){
        int n = 8;

        for(int i=0;i<n;i++){
            MultiThreading ob = new MultiThreading();
            ob.start();
        }
        System.out.println("lets take a break!");

        for(int i=0;i<n;i++){
            Thread object = new Thread(new MultithreadingDemo());
            object.start();
        }

    }
}