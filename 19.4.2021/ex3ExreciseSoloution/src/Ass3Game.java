import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.*;

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
        GUI gui = new GUI("game",800,600);
        GameEnvironment gameEnvironment = new GameEnvironment();
        Ball ball = new Ball(400,300,5, Color.BLUE);
        Block b1 = new Block(0,0,0,100,100,0);
        Block b2 = new Block(0,500,0,600,100,600);
        Block b3 = new Block(700,0,800,0,800,100);
        Block b4 = new Block(700,600,800,600,800,500);
        Block b5 = new Block(2,100,2,500,-30,300);
        Block b6 = new Block(100,0,700,0,400,-30);
        Block b7 = new Block(800,100,800,500,830,300);
        Block b8 = new Block(100,0,700,0,400,-30);
//        Block b4 = new Block(700,600,800,600,800,500);
//        Block b4 = new Block(700,600,800,600,800,500);
        Sleeper sleeper = new Sleeper();
        ball.setVelocity(20,8);
        ball.setGameEnvironment(gameEnvironment);

        gameEnvironment.addCollidable(b1);
        gameEnvironment.addCollidable(b2);
        gameEnvironment.addCollidable(b3);
        gameEnvironment.addCollidable(b4);
        gameEnvironment.addCollidable(b5);
        gameEnvironment.addCollidable(b6);

        boolean x =true;
        while(x) {
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gameEnvironment.drawAllOn(d);
            ball.moveOneStep();
            sleeper.sleepFor(100);
            gui.show(d);
        }
//        //create a game objects, initialize game and run it.
//        Game game = new Game();
//        game.initialize();
//        game.run();
    }
}
