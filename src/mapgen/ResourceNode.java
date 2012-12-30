/*
 * ResourceNode.java
 *
 * Created on 29-Dec-2012
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

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ResourceNode {

    int x, y;
    int income_per_tick;
    boolean rich = false;
    Image _image;
    float scale;

    ResourceNode(int x, int y, boolean rich) {

        this.x = x;
        this.y = y;

        if (rich) {
            income_per_tick = 5;
            scale = 2f;
        } else {
            income_per_tick = 10;
            scale = 1f;
        }

        _image = game.ResourceManager.getInstance().getImage("ResourceAnimation");

    }
    
    public int getIncomeValue() {
        return income_per_tick;
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.orange);
        
        
        _image.draw(x, y, scale);
    }
}
