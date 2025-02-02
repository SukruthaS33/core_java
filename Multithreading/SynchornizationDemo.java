package multithreading.Interrupts;

public class SynchronizationDemo {

	public static void main(String[] args) {
		 SeatBooker seatBooker = new SeatBooker(); // Single instance for both threads
		Person p1 = new Person("Ali", 4, 24,seatBooker);
		Person p2 = new Person("Ramesh", 2, 25,seatBooker);

		p1.start(); // Start thread
		p2.start(); // Start thread
	}
}

class SeatBooker {
    private static int totalSeats = 4;

    public  String bookTheSeat(Person p) {
//        System.out.println("total seats left " + totalSeats);
        if (totalSeats >= p.getSeatsBooking()) {
//            System.out.println("booking in process...........");
            totalSeats = totalSeats - p.getSeatsBooking();
//            System.out.println("remaining seats " + totalSeats);
            return p.getSeatsBooking() + " Seats booked for " + Thread.currentThread().getName();
        } else {
            return "unable to book for "+Thread.currentThread().getName();
        }
    }
}

class Person extends Thread {
    private String name;
    private int noOfSeats;
    private int age;
    private SeatBooker sb;

    public Person(String name, int noOfSeats, int age,SeatBooker sb) {
        this.name = name;
        this.noOfSeats = noOfSeats;
        this.age = age;
        this.sb = sb;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
       
        System.out.println(sb.bookTheSeat(this)); // Using the same seatBooker
    }

    public int getSeatsBooking() {
        return noOfSeats;
    }
}



