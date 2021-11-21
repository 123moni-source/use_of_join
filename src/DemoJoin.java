//Using join() to wait for threads to finish.
class NewThread implements Runnable {
    String name;//name of thread
    Thread t;

    NewThread(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        t.start();// start the thread
    }
// this is the entry point for thread.
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ":" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException obj) {
            System.out.println(name + "interrupted");
        }
        System.out.println(name + "exiting");
    }
}
    class DemoJoin {
    public static void main(String[] args) {
        NewThread obj1=new NewThread("One");
        NewThread obj2=new NewThread("Two");
        NewThread obj3=new NewThread("Three");
        System.out.println("Thread one is alive:"+obj1.t.isAlive());
        System.out.println("Thread one is alive:"+obj2.t.isAlive());
        System.out.println("Thread one is alive:"+obj3.t.isAlive());
        //wait fo threads to finish
        try
        {
            System.out.println("Waiting for threads to finish.");
            obj1.t.join();
            obj2.t.join();
            obj3.t.join();
        }catch(InterruptedException e)
        {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Thread one is alive:"+obj1.t.isAlive());
        System.out.println("Thread one is alive:"+obj2.t.isAlive());
        System.out.println("Thread one is alive:"+obj3.t.isAlive());
        System.out.println("Main thread exiting.");
    }
}
