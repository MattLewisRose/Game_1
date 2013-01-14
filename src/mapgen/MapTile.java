/*
 * MapTile.java
 *
 * Created on 03-Dec-2012
 * @Author Harry
 *
 * Copyright(c) 2012  Harry Torry.  All Rights Reserved.
 * This software is the proprietary information of Harry Torry.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted under the terms of the BSD License,
 *  with the following additional (non-free) restrictions:
 *  
 *  1.)  No portion of this notice shall be removed.
 *  2.)  Credit shall not be taken for the creation of this source.
 *  3.)  This code is not to be traded, sold, or used for gain or profit.
 *
 *
 */
package mapgen;

import java.awt.Point;
import java.util.Random;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class MapTile {

    int x, y;
    float light_value;
    Image _tileImage;
    boolean buildable = false;
    private Point centre;

    MapTile(int type, int x, int y, SpriteSheet _spriteSheet) {

        this.x = x;
        this.y = y;
        this.light_value = 0.5f;

        this.centre = new Point(x + (16 / 2), y + (16 / 2));

        if (type < 16) {
            _tileImage = _spriteSheet.getSubImage(type, 0);
        }

        switch (type) {

            case 1:
                //System.out.println("asd");
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;

            /*
             * From here onwards are specific tiles
             * 
             */

            // Base tile
            case 100:
                _tileImage = _spriteSheet.getSubImage(0, 1);
                buildable = true;
                this.light_value = 1f;
                break;



            default:
                //System.out.println("asd2");
                break;
        }


    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        _tileImage.draw(x, y);
    }

    public float getDefaultLight() {
        return this.light_value;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Point getCentre() {
        return this.centre;
    }
}
