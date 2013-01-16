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

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class LightManager {

    private boolean numbers_on = false;
    private boolean lighting_on = false;
    ArrayList<Light> lights = new ArrayList<>();
    float[][] default_light_value;
    float[][] calculated_light_value;
    Shape circle = new Ellipse(0f, 0f, 40f, 40f, 6);
    Shape[][] test; // The hitboxes for each square
    mapgen.MapTile[][] tiles;
    float step;
    Shape final_fog;

    // Maps is 53x50
    public LightManager(mapgen.MapTile[][] tile) {

        default_light_value = new float[53][50];
        calculated_light_value = new float[53][50];
        tiles = tile;

        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 53; x++) {
                default_light_value[x][y] = tile[x][y].getDefaultLight();
                if (default_light_value[x][y] == 1f) {
                }
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
                default_light_value[x][y] = tiles[x][y].getDefaultLight();

            }
        }


        calculated_light_value = default_light_value;
        this.lights = lights;

        Input input = container.getInput();
        lights.get(1).setHitboxLocation((int) (input.getMouseX() - 10f), (int) (input.getMouseY() - 10f));

        // Temporary to show the dynamically moving light.
        step += 0.0025;
        step %= 1;
        int newx = (int) (-1 * Math.sin(step) * 500) + 600;
        int newy = (int) ((int) (-1 * Math.sin(step) * 500) * 0.5 + 400);
        lights.get(0).setHitboxLocation((int) newx, (int) newy);


        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 53; x++) {
                for (int i = 0; i < lights.size(); i++) {
                    Shape tmp = lights.get(i).getHitbox();
                    if (tmp.contains(test[x][y])) {
                        calculated_light_value[x][y] = 1f;
                    }
                }
            }
        }
    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        g.setColor(Color.darkGray);
        if (numbers_on) {
            for (int y = 0; y < 50; y++) {
                for (int x = 0; x < 53; x++) {

                    float value = calculated_light_value[x][y];
                    String str = "a";
                    if (value == 0.5f) {
                        str = "0";
                    }
                    if (value == 1.0f) {
                        str = "1";
                    }
                    g.drawString(str, (x * 16) + 3, (y * 16) + 0);
                }
            }
        }
        for (int i = 0; i < lights.size(); i++) {
            Shape tmp = lights.get(i).getHitbox();
           // g.draw(tmp);
        }

        if (lighting_on) {
            for (int y = 0; y < 50; y++) {
                for (int x = 0; x < 53; x++) {
                    if (calculated_light_value[x][y] == 1f) {
                        // Light
                    } else {
                        // No light
                        g.fillRect(x * 16, y * 16, 16, 16);

                    }
                }
            }



        }
    }
}
