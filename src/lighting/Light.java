/*
 * Light.java
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

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;


public class Light {

    public Color colour;
    public float x, y, alpha, strength, size;
    private Shape hitbox;
    
    public Light(float x, float y, float alpha, float scale, float strength) {

        this.alpha = alpha;
        this.size = scale * 25f;
        this.x = x;
        this.y = y;
        // this.colour = new Color((int) Math.random() * 255, (int) Math.random() * 255, (int) Math.random() * 255);
        this.colour = Color.blue;
        this.hitbox = new Ellipse(x, y, size, size, 12);
    }

    public void setLocation(int x, int y) {
        this.x = x - (this.size / 2);
        this.y = y - (this.size / 2);
    }

    public Color getTint() {
        return colour;
    }
    
    public Shape getHitbox() {
        return this.hitbox;
    }
    
    public void setHitboxLocation(int x, int y) {
        this.hitbox.setX(x);
        this.hitbox.setY(y);
    }
    
    
}
