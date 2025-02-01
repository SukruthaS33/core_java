package multithreading.Sleep;

class SingingThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Singing: La la la...");
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}

class BackgroundMusicThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Playing background music...");
            try { Thread.sleep(700); } catch (InterruptedException e) {}
        }
    }
}

public class MultiThreadingExample {
    public static void main(String[] args) {
        SingingThread singer = new SingingThread();
        BackgroundMusicThread music = new BackgroundMusicThread();
        
        singer.start();
        music.start();
    }
}
