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

import java.util.Random;
import org.newdawn.slick.SpriteSheet;

public class One {

    int base_width = 5;
    int base_height = 5;
    
    public static MapTile[][] create(int width, int height, int tile_size, SpriteSheet _spriteSheet) {
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

        for (int y = 38; y < 48; y++) {
            for (int x = 2; x < 17; x++) {
            
                result[x][y] = new MapTile(MAP.TILE_BASE_GROUND, x * tile_size, y * tile_size, _spriteSheet);
            
            }
        }





        return result;
    }
}
