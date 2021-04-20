//import biuoop.DrawSurface;
//import biuoop.GUI;
//import biuoop.Sleeper;
//
//import java.awt.Color;
//
///**
// * @author Itay Gradenwits 213713522.
// */
//public class Game {
//    private static final int WIDTH_OF_SCREEN = 800;
//    private static final int HEIGHT_OF_SCREEN = 600;
//    private static final int WIDTH_OF_PADDLE = 200;
//    private static final int HEIGHT_OF_PADDLE = 15;
//    private static final int WIDTH_OF_FRAME = 15;
//    private static final int WIDTH_OF_BLOCKS = 60;
//    private static final int HEIGHT_OF_BLOCKS = 25;
//    private Paddle paddle;
//    private GUI gui;
//    private SpriteCollection sprites;
//    private GameEnvironment environment;
//
//    /**
//     * constructor.
//     */
//    public Game() {
//        gui = new GUI("Arknoid", 800, 600);
//        paddle = new Paddle(gui, new Rectangle(new Point(300, HEIGHT_OF_SCREEN - WIDTH_OF_FRAME
//                - HEIGHT_OF_PADDLE), WIDTH_OF_PADDLE, HEIGHT_OF_PADDLE, Color.YELLOW), WIDTH_OF_FRAME, WIDTH_OF_SCREEN);
//
//        sprites = new SpriteCollection();
//        environment = new GameEnvironment();
//    }
//
//    /**
//     * addCollidable -- add a new Collidable object to the gameEnvironment of the game.
//     *
//     * @param c is a new Object to add to the game Environment.
//     */
//    public void addCollidable(Collidable c) {
//        environment.addCollidable(c);
//    }
//
//    /**
//     * addSprite -- add a new Sprite object to the SpriteList of the game.
//     *
//     * @param s is a new Object to add to the SpriteList.
//     */
//    public void addSprite(Sprite s) {
//        sprites.addSprite(s);
//    }
//
//    // Initialize a new game: create the Blocks and Ball (and Paddle)
//    // and add them to the game.
//
//    /**
//     * Initialize -- Initialize a new game: create the Blocks and Ball (and Paddle)
//     * and add them to the game.
//     */
//    public void initialize() {
//        //create a Sprite that will be the  blue backGround of the screen.
//        addSprite(new Block(new Rectangle(new Point(WIDTH_OF_FRAME, WIDTH_OF_FRAME), WIDTH_OF_SCREEN
//                - 2 * WIDTH_OF_FRAME, HEIGHT_OF_SCREEN - 2 * WIDTH_OF_FRAME, new Color(0, 0, 139))));
//        //add the paddle to the game environment and to the spriteList.
//        paddle.addToGame(this);
//        //create a colors array for the blocks.
//        Color[] colors = new Color[6];
//        colors[0] = Color.DARK_GRAY;
//        colors[1] = Color.red;
//        colors[2] = Color.yellow;
//        colors[3] = Color.blue;
//        colors[4] = Color.magenta;
//        colors[5] = Color.green;
//
//        //create the frame of the game (4 blocks that make sure that the ball stay in the screen.
//        Block block1 = new Block(new Rectangle(new Point(0, 0), WIDTH_OF_SCREEN, WIDTH_OF_FRAME,
//                Color.DARK_GRAY));
//
//        Block block2 = new Block(new Rectangle(new Point(0, WIDTH_OF_FRAME), WIDTH_OF_FRAME, HEIGHT_OF_SCREEN
//                - 2 * WIDTH_OF_FRAME, Color.DARK_GRAY));
//
//        Block block3 = new Block(new Rectangle(new Point(0, HEIGHT_OF_SCREEN - WIDTH_OF_FRAME),
//                WIDTH_OF_SCREEN, WIDTH_OF_FRAME, Color.DARK_GRAY));
//
//        Block block4 = new Block(new Rectangle(new Point(WIDTH_OF_SCREEN - WIDTH_OF_FRAME, WIDTH_OF_FRAME),
//                WIDTH_OF_FRAME, HEIGHT_OF_SCREEN - 2 * WIDTH_OF_FRAME, Color.DARK_GRAY));
//
//        //add the frame blocks to the gmeEnvironment.
//        addCollidable(block1);
//        addCollidable(block2);
//        addCollidable(block3);
//        addCollidable(block4);
//
//        // create blocks to put in the game and add them to the gameEnvironment.
//        for (int j = 0; j < 6; j++) {
//            for (int i = WIDTH_OF_SCREEN - WIDTH_OF_FRAME - WIDTH_OF_BLOCKS; i > WIDTH_OF_SCREEN - WIDTH_OF_FRAME
//                    - WIDTH_OF_BLOCKS - WIDTH_OF_BLOCKS * (12 - j); i -= WIDTH_OF_BLOCKS) {
//
//                addCollidable(new Block(new Rectangle(new Point(i, 130 + ((j - 1) * HEIGHT_OF_BLOCKS)),
//                        WIDTH_OF_BLOCKS, HEIGHT_OF_BLOCKS, colors[j])));
//
//                addSprite(new Block(new Rectangle(new Point(i, 130 + ((j - 1) * HEIGHT_OF_BLOCKS)),
//                        WIDTH_OF_BLOCKS, HEIGHT_OF_BLOCKS, colors[j])));
//            }
//        }
//
//        // add the blocks to the SpriteList too.
//        addSprite(block1);
//        addSprite(block2);
//        addSprite(block3);
//        addSprite(block4);
//
//        // create 2 balls and add them to the game.
//        Ball ball1 = new Ball(new Point(300, 300), 5, Color.BLUE, this.environment);
//        ball1.setVelocity(3, 3);
//        addSprite(ball1);
//
//        Ball ball2 = new Ball(new Point(330, 330), 5, Color.RED, this.environment);
//        ball2.setVelocity(-3, 3);
//        addSprite(ball2);
//
//		Ball ball3 = new Ball(new Point(230, 330), 5, Color.GREEN, this.environment);
//        ball3.setVelocity(3, -3);
//        addSprite(ball3);
//
//		Ball ball4 = new Ball(new Point(310, 330), 5, Color.YELLOW, this.environment);
//        ball4.setVelocity(-4, 3);
//        addSprite(ball4);
//
//		Ball ball5 = new Ball(new Point(330, 330), 5, Color.PINK, this.environment);
//        ball5.setVelocity(3, -5);
//        addSprite(ball5);
//
//		Ball ball6 = new Ball(new Point(311, 330), 5, Color.GRAY, this.environment);
//        ball6.setVelocity(3, 6);
//        addSprite(ball6);
//    }
//
//    /**
//     * run the game.
//     */
//    public void run() {
//
//        //tools to use timing
//        Sleeper sleeper = new Sleeper();
//        int framesPerSecond = 60;
//        int millisecondsPerFrame = 1000 / framesPerSecond;
//        while (true) {
//            long startTime = System.currentTimeMillis(); // timing
//
//            // draw the sprite objects on DrawSurface and activate TimePassed.
//            DrawSurface d = this.gui.getDrawSurface();
//            this.sprites.drawAllOn(d);
//            gui.show(d);
//            this.sprites.notifyAllTimePassed();
//
//            // timing
//            long usedTime = System.currentTimeMillis() - startTime;
//            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
//            if (milliSecondLeftToSleep > 0) {
//                sleeper.sleepFor(milliSecondLeftToSleep);
//            }
//        }
//    }
//}
