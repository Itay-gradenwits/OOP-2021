package GUI;

import biuoop.DrawSurface;
/**
 * @author Itay Gradenwits 213713522.
 */
public interface Sprite {
    /**
     * drawOn -- draw the sprite to the screen.
     * @param d is a DrawSurFace object.
     */
    void drawOn(DrawSurface d);

    /**
     * timePassed --notify the sprite that time has passed.
     */

    void timePassed();
}
