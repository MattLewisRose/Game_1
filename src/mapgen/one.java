/*
 * one.java
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

import org.newdawn.slick.SpriteSheet;

public class one {

    one() {
    }

    public static MapTile[][] create(int width, int height, int tile_size, SpriteSheet _spriteSheet) {
        MapTile[][] result = new MapTile[width][height];


        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result[x][y] = new MapTile(1, x * tile_size, y * tile_size, _spriteSheet);
            }
        }

        return result;
    }
}
