package multithreading.Synchronization;
//mutliple students asking a question to the teacher at once
public class SynchronizedAnalogy {
    public static void main(String[] args) {
        ClassTeacher t = new ClassTeacher("Gary");
        
        ClassStudent cs1 = new ClassStudent("Harry", t, "What is polymorphism?");
        ClassStudent cs2 = new ClassStudent("Jay", t, "What is multithreading?");
        
        Thread studentOne = new Thread(cs1);
        Thread studentTwo = new Thread(cs2);
        
        studentOne.start();
        studentTwo.start();
    }
}

class ClassStudent implements Runnable {
    private String name;
    private ClassTeacher teacher;
    private String question;

    public ClassStudent(String name, ClassTeacher teacher, String question) {
        this.name = name;
        this.teacher = teacher;
        this.question = question;
    }

    @Override
    public void run() {
        teacher.askQuestion(name, question);
    }
}

// Shared Resource (No Synchronization)
class ClassTeacher {
    private String name;
    private String question;

    ClassTeacher(String name) {
        this.name = name;
    }

    public void askQuestion(String studentName, String question) {
    	 this.question = question;
        System.out.println(studentName + " asks: " + this.question);
       
        // Simulating processing time before storing the question
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         // Overwritten if another thread modifies it
        System.out.println(name + " (Teacher) sees the question: " + this.question +" from "+studentName);
    }
}
