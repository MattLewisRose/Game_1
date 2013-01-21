/*
 * Barracks.java
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

package building;

public class Barracks extends Buildable implements BuildableInterface {

    public Barracks(int type, int x, int y){
        super(type, x, y);
        

    }

    @Override
    public void onClick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onCreate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onDestroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onCreateUnit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
}
