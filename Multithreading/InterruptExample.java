package multithreading.Sleep;

public class InterruptExample {

    public static void main(String[] args) {

        // Create the Bulldog thread
        BullDog bullDog = new BullDog();
        bullDog.start();  // Start Bulldog first
        
        // Create the Tom thread and set the Bulldog for interruption
        Tom tomThread = new Tom();
        tomThread.setBullDog(bullDog);
        tomThread.start();  // Start Tom thread, it will interrupt Bulldog later
    }
}

class Tom extends Thread {

    BullDog bd = null;
    
    @Override
    public void run() {
        try {
            // Wait for a moment before Tom interrupts Bulldog (simulate Tom running)
            Thread.sleep(2000);  // Wait for 2 seconds

            System.out.println("Tom disturbs the perfectly asleep bull dog!: " + bd);
            
            // Tom interrupts Bulldog after waiting for 2 seconds
            bd.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void setBullDog(BullDog bd) {
        this.bd = bd;
    }
}

class BullDog extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Bulldog is sleeping zzzz shhhhh...");
            // Simulate Bulldog sleeping for 50 seconds (it will be interrupted by Tom)
            Thread.sleep(50000); 
        } catch (InterruptedException e) {
            System.out.println("Who is it there!!! Grrrrrrrrr Grrrrrr");
            e.printStackTrace();  // Bulldog reacts when interrupted
        }
    }
}
