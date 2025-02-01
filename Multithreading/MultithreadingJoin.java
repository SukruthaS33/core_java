package multithreading.Sleep;

public class MultithreadingJoin {

    public static void main(String[] args) {
        Son sonThread = new Son();
        Mom momThread = new Mom();
        Dad dadThread = new Dad();

        try {
            sonThread.start();
            sonThread.join();   

            momThread.start();
            momThread.join();   

            dadThread.start(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Mom extends Thread {
    @Override
    public void run() {
        System.out.println("Cutting veggies");
        System.out.println("Cooking rice");
        System.out.println("Pack lunch");
    }
}

class Dad extends Thread {
    @Override
    public void run() {
        System.out.println("Start the bike to drop son");
    }
}

class Son extends Thread {
    @Override
    public void run() {
        System.out.println("Wakes up at 5AM and studies");
        System.out.println("Gets ready to go to school");
    }
}
