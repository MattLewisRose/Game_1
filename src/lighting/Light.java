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

public class Light {

    public Color colour;
    public float x, y, alpha, scale;
    
    
    
    public Light(float x, float y, float alpha, float scale){
       this.x = x;
       this.y = y;
       this.alpha = alpha;
       this.scale = scale;
       
      // this.colour = new Color((int) Math.random() * 255, (int) Math.random() * 255, (int) Math.random() * 255);
       this.colour = Color.blue;
      
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Color getTint() {
        return colour;
    }
    
}
