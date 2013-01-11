/*
 * LightManager.java
 *
 * Created on 02-Jan-2013
 * @Author Harry
 *
 * Copyright(c) 2013  Harry Torry.  All Rights Reserved.
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
package lighting;

import java.awt.Point;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.geom.Rectangle;

public class LightManager {

    ArrayList<Light> lights = new ArrayList<>();
    float[][][] default_light_value;
    float[][][] calculated_light_value;
    Shape circle = new Ellipse(0f, 0f, 40f, 40f, 6);
    Shape[][] test; // The hitboxes for each square
    mapgen.MapTile[][] tiles;

    // Maps is 53x50
    public LightManager(mapgen.MapTile[][] tile) {

        default_light_value = new float[53][50][];
        tiles = tile;

        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 53; x++) {
                default_light_value[x][y] = tile[x][y].getDefaultLight();
            }
        }

        int tile_size = 16;
        test = new Rectangle[53][50];
        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 53; x++) {
                test[x][y] = new Rectangle((x * 16) + 8, (y * 16) + 8, 2, 2);
            }

        }
    }

    public void UpdateDefaultTile(mapgen.MapTile tile) {
        // get x,y from 'tile', then update the default_light_value for it
    }

    public void update(GameContainer container, StateBasedGame game, int delta, ArrayList<Light> lights) throws SlickException {

        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 53; x++) {
                default_light_value[x][y][0] = 0;
            }
        }

        calculated_light_value = default_light_value;
        this.lights = lights;

        Input input = container.getInput();
        circle.setLocation(input.getMouseX() - 10f, input.getMouseY() - 10f);



        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 53; x++) {
                if (circle.contains(test[x][y])) {
                    calculated_light_value[x][y][0] = 2f;
                }
            }
        }
    }

    public void render(GameContainer container, Graphics g) throws SlickException {

        //g.setDrawMode(Graphics.MODE_ALPHA_BLEND);


        g.fill(circle);

        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 53; x++) {
                g.setColor(Color.black);
                float value = default_light_value[x][y][0];
                String str = "a";
                if (value == 0.5f) {
                    str = "0";
                }
                if (value == 1.0f) {
                    str = "1";
                }
                if (value == 2.0f) {
                    str = "2";
                }
                g.drawString(str, (x * 16) + 3, (y * 16) + 0);
            }
        }

        for (int i = 0; i < lights.size(); i++) {
            Light light = lights.get(i);
            g.drawOval(light.x, light.y, light.size, light.size);
        }

        g.setDrawMode(Graphics.MODE_NORMAL);
    }
}
