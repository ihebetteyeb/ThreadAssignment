public class ThreadAssignment {

    static class Counter {
        //implementation de la methode count
        void count() {
            for(int i=350;i>=1;i--){
                System.out.println(i);
            }
            System.out.println("FINISH !");
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
           //synchronized object
            synchronized (counter) {counter.count();}
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

       MyThread th1 =  new MyThread(counter);
       MyThread th2 = new MyThread(counter);

        th1.start();
        try{
            th1.join();
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        th2.start();
        try{
            th2.join();
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        System.out.println("DONE !");
    }
}
