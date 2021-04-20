public interface Student {
    void doHomeWork();

    default void raiseHand() {
        System.out.println("raising hand");
    }
}
