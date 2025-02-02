package multithreading.Sleep;

public class MultithreadingJoin2 {

	public static void main(String[] args) throws InterruptedException {
		Sonn s = new Sonn();
		Mother m = new Mother();

		m.start();
		m.join();
		s.start();//son waits for mother to finish preparing breakfast before beginning to eat
	}
}

class Sonn extends Thread {

	@Override
	public void run() {
		System.out.println("Begin eating breakfast");

	}
}

class Mother extends Thread {

	@Override
	public void run() {
		System.out.println("Preparing breakfast");
		System.out.println("Breakfast done! Phew ");

	}
}
