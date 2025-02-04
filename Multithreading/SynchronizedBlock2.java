package multithreading.Synchronization;

public class SynchronizedBlock2 {

	public static void main(String[] args) {
		PrincipallRoom pr = new PrincipallRoom();
		SchoolMember student1 = new Studentt(pr, true);
		SchoolMember student2 = new Studentt(pr, false);

		Thread studentOne = new Thread((Runnable) student1);
		Thread studentTwo = new Thread((Runnable) student2);
		PrincipallRoom pr2 = new PrincipallRoom();//think of this being triggered from a different Teacher class which is outside of this particular , we have only written for easeness
		Teacher teacher1 = new Teacher(pr2, true);
		Thread teacherOne = new Thread((Runnable) teacher1);
		studentOne.setName("Student1");
		studentTwo.setName("Student2");
		teacherOne.setName("Teacher1");
		studentOne.start();
		 //studentTwo.start();
		teacherOne.start();

	}

}

class SchoolMember {
	boolean isGoodMember;

}

class Studentt extends SchoolMember implements Runnable {

	PrincipallRoom p = null;

	public Studentt(PrincipallRoom p, boolean isGoodMember) {
		this.p = p;
		this.isGoodMember = isGoodMember;
	}

	@Override
	public void run() {

		p.talkToPrincipal(this);
	}
}

class Teacher extends SchoolMember implements Runnable {

	PrincipallRoom p = null;

	public Teacher(PrincipallRoom p, boolean isGoodMember) {
		this.p = p;
		this.isGoodMember = isGoodMember;
	}

	@Override
	public void run() {

		p.talkToPrincipal(this);
	}
}

class PrincipallRoom {

	Principall p = new Principall();
	private static int leaveCount = 0;
	private boolean isPrinicipalTalking = false;

	public synchronized void talkToPrincipal(SchoolMember stu) {

		System.out.println("show required documents");
		System.out.println("asking permission with security");
		System.out.println("sit in the waiting lounge");

		if (!p.isPriciTalking()) {
			System.out.println("Get the chance=================== " + Thread.currentThread().getName());
			System.out.println(p.isPriciTalking());
			System.out.println("Hi ma'am");
			p.talk(stu, leaveCount);

		}

		else {
			System.out.println("wait");
		}

	}
}

class Principall {

	boolean isPrinicipalTalking = false;

	public void talk(SchoolMember stu, int leaveCount) {
		isPrinicipalTalking = true;
		System.out.println("Hi :) " + Thread.currentThread().getName());
		this.submitLeaveRequest(stu, leaveCount);
	}

	public void submitLeaveRequest(SchoolMember stu, int leaveCount) {
		System.out.println("I will look into it !");
		System.out.println("Leave request submitted ");
		if (stu.isGoodMember) {
			System.out.println("leave approved");
			leaveCount++;
		}

		else {
			System.out.println("Sorry , I really hope you improve and then we'll see");
		}

		System.out.println("===========================exit============== " + Thread.currentThread().getName());
		isPrinicipalTalking = false;
	}

	public boolean isPriciTalking() {
		return this.isPrinicipalTalking;
	}

}
