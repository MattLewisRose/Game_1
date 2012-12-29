/*
 * One.java
 *
 * Created on 28-Dec-2012
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

import java.util.ArrayList;
import java.util.Random;
import org.newdawn.slick.SpriteSheet;

public class One {

    public static MapTile[][] create(int width, int height, int tile_size, SpriteSheet _spriteSheet) {


        int base_width = 14;
        int base_height = 10;

        MapTile[][] result = new MapTile[width][height];

        /*
         * 
         * Make the base of the map completely random
         * 
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int pickedNumber = new Random().nextInt(4);

                result[x][y] = new MapTile(pickedNumber, x * tile_size, y * tile_size, _spriteSheet);
            }
        }

        /*
         * 
         * Set up the base ground area
         * 
         */

        // Bottom left
        for (int y = 38; y < (38 + base_height); y++) {
            for (int x = 2; x < 2 + base_width; x++) {
                result[x][y] = new MapTile(MAP.TILE_BASE_GROUND, x * tile_size, y * tile_size, _spriteSheet);

            }
        }
        // Top right 
        for (int y = 2; y < (2 + base_height); y++) {
            for (int x = 37; x < 37 + base_width; x++) {
                result[x][y] = new MapTile(MAP.TILE_BASE_GROUND, x * tile_size, y * tile_size, _spriteSheet);

            }
        }

        return result;
    }

    public static ArrayList<ResourceNode> createResourceNodes() {
        ArrayList<ResourceNode> result = new ArrayList<>();

        // Bottom left
        result.add(new ResourceNode(130, 480, false));
        result.add(new ResourceNode(350, 690, false));

        // Top right
        result.add(new ResourceNode(500, 112, false));
        result.add(new ResourceNode(700, 250, false));

        // Middle
        result.add(new ResourceNode(125, 125, false));
        result.add(new ResourceNode(400, 400, true));
        result.add(new ResourceNode(650, 650, false));

        return result;

    }
}
