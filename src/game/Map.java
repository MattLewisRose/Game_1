/*
 * Map.java
 *
 * Created on 29-Nov-2012
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
import mapgen.MapTile;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapgen.ResourceNode;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class Map {

    final int tile_size = 16;
    final int width = (1024 - 176) / tile_size; // 53
    final int height = 800 / tile_size; // 50
    SpriteSheet _spriteSheet;
    private MapTile[][] map;
    ArrayList<ResourceNode> resourceNodes = new ArrayList<ResourceNode>();


    Map() {
        Image a = ResourceManager.getInstance().getImage("map_1");
        try {
            _spriteSheet = new SpriteSheet("/data/image/map_1.png", tile_size, tile_size);
        } catch (SlickException ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        }

        map = mapgen.a.create(width, height, tile_size, _spriteSheet);
        resourceNodes = mapgen.a.createResourceNodes();
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        for (int i = 0; i < resourceNodes.size(); i++) {
            resourceNodes.get(i).update(container, game, delta);
        }
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                map[x][y].render(container, game, g);

            }
        }
        for (int i = 0; i < resourceNodes.size(); i++) {
            resourceNodes.get(i).render(container, game, g);
        }
    }

    public MapTile[][] getMap() {
        return this.map;
    }
}
