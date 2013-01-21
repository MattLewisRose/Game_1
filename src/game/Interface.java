/*
 * Interface.java
 *
 * Created on 23-Dec-2012
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

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class Interface {

    public final static int INGAME_width = 176;
    private Image INGAME_background;
    ArrayList<InterfaceButton> GameButtons = new ArrayList<>();
    public final static int MOUSE_STATE_EMPTY = 0;
    public final static int MOUSE_STATE_ATTACK = 1;
    public final static int MOUSE_STATE_BUILD_BARRACKS = 10;
    int mouse_state = 0;
    int mouseX = 0;
    int mouseY = 0;
    int imageX = 0;
    int imageY = 0;
    Image mouseImage;
    Shape[][] buildableArea = new Shape[14][10];
    boolean[][] builtArea = new boolean[14][10];
    int buildingLocationValueInArray_X = 0; // Used to set the builtArea location
    int buildingLocationValueInArray_Y = 0; // Used to set the builtArea location

    Interface() {
        INGAME_background = ResourceManager.getInstance().getImage("ingame_background");

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 14; x++) {
                builtArea[x][y] = false;
                buildableArea[x][y] = new Rectangle((2 * 16) + (x * 16) + 8, (38 * 16) + (y * 16) + 8, 3, 3);
            }
        }

        GameButtons.add(new InterfaceButton("interface_button_barrack", 880, 85) {
            @Override
            void onClick() {
                mouse_state = MOUSE_STATE_BUILD_BARRACKS;
            }
        });

    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        Input input = container.getInput();
        mouseX = input.getMouseX();
        mouseY = input.getMouseY();


        boolean isLeftMouseClicked = false;
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            isLeftMouseClicked = true;
        }

        if (isLeftMouseClicked) {
            for (int i = 0; i < GameButtons.size(); i++) {
                GameButtons.get(i).update(container, game, delta);
            }
        }

        if (isLeftMouseClicked) {
            switch (mouse_state) {
                case MOUSE_STATE_EMPTY:
                    break;
                case MOUSE_STATE_ATTACK:
                    // Set mouse icon to the attack icon animation
                    break;

                case MOUSE_STATE_BUILD_BARRACKS:
                    mouseImage = ResourceManager.getInstance().getImage("ingame_building_barrack");

                    if ((mouseX >= 0) && (mouseX <= 848) && (mouseY >= 0) && (mouseY <= 800)) {
                        mouse_state = MOUSE_STATE_EMPTY;
                        //mouseImage = new Image(1, 1);
                        Shape temp = getClosestTile();

                        builtArea[buildingLocationValueInArray_X][buildingLocationValueInArray_Y] = true;
                        GameState.addBuilding(new building.Barracks(building.Buildable.BUILDING_BARRACKS, (int) temp.getX() - 8, (int) temp.getY() - 8));
                    }
                    break;
            }
        }

        Shape temp = getClosestTile();
        imageX = (int) temp.getX();
        imageY = (int) temp.getY();


    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

        INGAME_background.draw(1024 - INGAME_width, 0);
        g.drawString("" + GameState.getTimeUntilNextDiceroll(), 950, 745);

        for (int i = 0; i < GameButtons.size(); i++) {
            GameButtons.get(i).render(container, game, g);
        }

        switch (mouse_state) {
            case MOUSE_STATE_EMPTY:
                break;
            case MOUSE_STATE_ATTACK:
                // Set mouse icon to the attack icon animation
                break;

            case MOUSE_STATE_BUILD_BARRACKS:
                mouseImage.draw(imageX - 8, imageY - 8);
                break;
        }


        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 14; x++) {
                //g.fill(buildableArea[x][y]);
            }
        }

    }

    private Shape getClosestTile() {
        Shape result = null;
        float lastDistance = 500000000;


        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 14; x++) {
                if (!builtArea[x][y]) {
                    int tileX = (int) buildableArea[x][y].getX();
                    int tileY = (int) buildableArea[x][y].getY();
                    float xx = (float) Math.pow(mouseX - tileX, 2);
                    float yy = (float) Math.pow(mouseY - tileY, 2);
                    float distance = (float) Math.sqrt(xx + yy);

                    if (distance < lastDistance) {
                        lastDistance = distance;
                        result = buildableArea[x][y];
                        buildingLocationValueInArray_X = x;
                        buildingLocationValueInArray_Y = y;
                    }
                }
            }
        }

        return result;
    }
}
