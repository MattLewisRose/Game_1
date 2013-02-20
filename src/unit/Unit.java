/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unit;

import game.ResourceManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Harry
 */
public class Unit {
    
    float x, y;
    int w, h, cost;
    Image baseImage;
    public static final int UNIT_SOLDIER = 1;

    Unit(int type, int x, int y) {
        this.x = x;
        this.y = y;

        switch (type) {
            case UNIT_SOLDIER:
                baseImage = ResourceManager.getInstance().getImage("ingame_building_barrack");
                break;

        }



    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        // Create new unit
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        baseImage.draw(x, y);
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getCost() {
        return this.cost;
    }

    public void setCost(int c) {
        this.cost = c;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
