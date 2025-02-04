package Corejavarefresher.multithreading;

public class SynchronizedBlock {

	public static void main(String[] args) {
		PrincipalRoom pr = new PrincipalRoom();
		Student student1 = new Student(pr,true);
		Student student2 = new Student(pr,false);
		student1.start();
		student2.start();
		
		
	}

}

class Student extends Thread {

	PrincipalRoom p = null;
	boolean isGoodStudent ;
	public Student(PrincipalRoom p,boolean isGoodStudent){
		this.p =p;
		this.isGoodStudent=isGoodStudent;
	}
	@Override
	public void run() {
			
		p.talkToPrincipal(this);
	}
}







 class PrincipalRoom {

	Principal p = new Principal();
	private static int leaveCount = 0;
	private boolean isPrinicipalTalking = false;

	public void talkToPrincipal(Student stu) {

		System.out.println("show required documents");
		System.out.println("asking permission with security");
		System.out.println("sit in the waiting lounge");
		System.out.println("Get the chance===================");
		// synchronized (p) {
		if (!p.isPriciTalking()) {
			System.out.println(p.isPriciTalking());
			System.out.println("Hi ma'am");
			p.talk(stu, leaveCount);

		}

		else {
			System.out.println("wait");
		}

		// }

	}

}

class Principal {

	boolean isPrinicipalTalking = false;

	public void talk(Student stu, int leaveCount) {
		isPrinicipalTalking = true;
		System.out.println("Hi kid :)");
		this.submitLeaveRequest(stu, leaveCount);
	}

	public void submitLeaveRequest(Student stu, int leaveCount) {
		System.out.println("I will look into it kiddo !");
		System.out.println("Leave request submitted ");
		if (stu.isGoodStudent) {
			System.out.println("leave approved");
			leaveCount++;
		}

		else {
			System.out.println("Sorry kid get your shit together");
		}

		System.out.println("===========================exit==============");
		isPrinicipalTalking = false;
	}

	public boolean isPriciTalking() {
		return this.isPrinicipalTalking;
	}

}
