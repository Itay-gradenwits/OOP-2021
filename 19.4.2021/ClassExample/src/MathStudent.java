public class MathStudent implements Student {
    @Override
    public void doHomeWork() {
        System.out.println("17 + 19 = 36");
    }

    public int calculateSum(int x, int y) {
        return x + y;
    }

    public int calculateMul(int x, int y) {
        return x*y;
    }

    @Override
    public void raiseHand() {
        System.out.println("raising hand in math");
    }
}
