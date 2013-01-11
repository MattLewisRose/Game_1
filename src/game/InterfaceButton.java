/*
 * InterfaceButton.java
 *
 * Created on 27-Dec-2012
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

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Harry
 */
public abstract class InterfaceButton {

    int x, y, w, h;
    Image buttonImage;

    InterfaceButton(String imageName, int x, int y) {

        buttonImage = ResourceManager.getInstance().getImage(imageName);

        this.x = x;
        this.y = y;
        this.w = buttonImage.getWidth();
        this.h = buttonImage.getHeight();
    }
    
    abstract void onClick();

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();

        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();

        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if ((mouseX >= x) && (mouseX <= (x + w)) && (mouseY >= y) && (mouseY <= (y + h))) {
                this.onClick();
                System.out.println("clicked");
            }
        }
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        buttonImage.draw(x, y);
    }


}
