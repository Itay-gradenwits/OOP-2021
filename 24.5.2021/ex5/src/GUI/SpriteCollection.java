package GUI;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Itay Gradenwits 213713522.
 */
public class SpriteCollection {
    private List<Sprite> spriteList;

    /**
     * Constructor -- creating an empty Sprite list to hold Sprite objects.
     */
    public SpriteCollection() {
        spriteList = new ArrayList<Sprite>();
    }

    /**
     * addSprite -- add a Sprite object to the SpriteCollection by adding it to the SpriteList.
     *
     * @param s is a Sprite object to add to the spriteCollection.
     */
    public void addSprite(Sprite s) {
        if (s == null) {
            throw new RuntimeException("Sprite s is not initialized");
        }
        spriteList.add(s);
    }

    /**
     * notifyAllTimePassed -- call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (Sprite sprite : spriteList) {
            sprite.timePassed();
        }
    }

    /**
     * drawAllOn -- call drawOn(d) on all sprites.
     *
     * @param d is a DrawSurface object to draw all the Sprite objects on.
     */
    public void drawAllOn(DrawSurface d) {
        if (d == null) {
            throw new RuntimeException("DrawSurface d is not initialized");
        }
        for (Sprite sprite : spriteList) {
            sprite.drawOn(d);
        }
    }
}
