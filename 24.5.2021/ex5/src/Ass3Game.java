
/**
 * Ass3Game -- create a game object and initialize and run the game.
 */
public class Ass3Game {
    /**
     * main -- the main function of the class that run the game.
     *
     * @param args is not used.
     */
    public static void main(String[] args) {
        //create a game objects, initialize game and run it.
        Game game = new Game();
        game.initialize();
        game.run();
    }
}
