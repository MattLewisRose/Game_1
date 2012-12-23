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
package game;

import java.util.Random;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class MapTile {

    int x, y;
    Image _tileImage;

    MapTile(int type, int x, int y, SpriteSheet _spriteSheet) {



        switch (type) {

            case 1:
                //System.out.println("asd");
                break;
            default:
                //System.out.println("asd2");
                break;
        }

        Random rand = new Random();
        int pickedNumber;

        /*
         if (x % 10 < 3) {
         pickedNumber = rand.nextInt(2);
         } else {
         pickedNumber = rand.nextInt(3);
         }

         if (y % 10 < 6) {
         if (pickedNumber < 2) {
         pickedNumber = 1;
         } else {
         pickedNumber = rand.nextInt(2) + 1;
         }

         }*/

        pickedNumber = rand.nextInt(4);
        

        _tileImage = _spriteSheet.getSubImage(pickedNumber, 0);

        this.x = x;
        this.y = y;

    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        _tileImage.draw(x, y);
    }
}
