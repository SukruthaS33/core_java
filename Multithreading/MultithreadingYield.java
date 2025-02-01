package multithreading.Sleep;

public class MultithreadingYield {

	
	public static void main(String[] args) {
		GroceryBill1 person1  = new GroceryBill1();
		GroceryBill2 person2  = new GroceryBill2();
		person1.setName("Graham");
		person2.setName("Anju");
		person1.start();
		person2.start();
		
		
	}
	
}


 class GroceryBill1 extends Thread{
	 
	 
	 @Override
	 public void run() {
		 Thread.yield();
		try {
			Thread.sleep(2000);
			for(int i=0;i<100;i++) {
				System.out.println("item "+i +"billing done");
			}
			 System.out.println("Thank you for shopping with us "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }
 }

 
 class GroceryBill2 extends Thread{
	 
	 
	 @Override
	 public void run() {
		 //Thread.yield();
		for(int i=0;i<1;i++) {
			System.out.println("item "+i +"billing done");
		}
		
		 System.out.println("Thank you for shopping with us "+Thread.currentThread().getName());
	 }
 }
