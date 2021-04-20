public class Main {

    public static void main(String[] args) {
        Class myClass = new Class();
        MathStudent Bar = new MathStudent();
        Student Maya = new HistoryStudent();
        Student Gal = new ScienceStudent();

        myClass.AddStudent(Bar);
        myClass.AddStudent(Maya);
        myClass.AddStudent(Gal);
        myClass.makeStudentsDoHomeWork();

        Gal.raiseHand();
        Maya.raiseHand();
        Bar.raiseHand();

//        down cast
//        System.out.println(((MathStudent) Bar).calculateSum(100,200));

        //run time error because cannot cast Science Student to math student.
//        System.out.println(((MathStudent) Gal).calculateSum(100,200));

        //compilation error because there is no such method for HistoryStudent.
//        System.out.println( Maya.calculateSum(100,200));

    }
}
