import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Class {
    private List<Student> students = new LinkedList<>();

    public void AddStudent(Student s) {
        students.add(s);
    }

    public void makeStudentsDoHomeWork() {
        for (Student s : students) {
            s.doHomeWork();
        }
    }

    public void makeMathStudentSolveRandomSumQuestion(MathStudent mathStudent) {
        Random random = new Random();
        int x = random.nextInt(100);
        int y = random.nextInt(100);
        System.out.println("teacher: solve this:" + x + " + " + y + " = ?");
        System.out.println("student:" + mathStudent.calculateSum(x,y));
    }
}
