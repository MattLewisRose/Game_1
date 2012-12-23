/*
 * particle.java
 *
 * Created on 21-Oct-2012
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
package effects;

import java.util.Random;
import org.newdawn.slick.geom.Vector2f;

public class particle {

    int x, y;
    Vector2f direction;
    
    int[] colour;
    private static int[][] colour_list = new int[][]{{255, 0, 0}, {0, 255, 0}, {0, 0, 255}};

    public particle() {
        int randomIndex = new Random().nextInt(colour_list.length);
        this.colour = colour_list[randomIndex];
        
        System.out.println(randomIndex);

    }
}
