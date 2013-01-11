/*
 * Interface.java
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
package game;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Interface {

    private int state = 1;
    public final static int STATE_MAINMENU = 0;
    public final static int STATE_INGAME = 1;
    public final static int INGAME_width = 176;
    private Image INGAME_background;
    ArrayList<InterfaceButton> GameButtons = new ArrayList<>();
    private Component frame;

    private Interface() {
        INGAME_background = ResourceManager.getInstance().getImage("ingame_background");

        //   GameButtons.add(new InterfaceButton("interface_button_barrack", 880, 85) {
        //       @Override
        //       void onClick() {
        //          System.out.println("Create new barracks, button.");
        //      }
        //   });
    }

    public static Interface getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    private static class NewSingletonHolder {

        private static final Interface INSTANCE = new Interface();
    }

    public void setStates(int _state) {
        this.state = _state;
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        Input input = container.getInput();
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {

            //JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
        }
        switch (state) {
            case STATE_MAINMENU:
                break;
            case STATE_INGAME:
                //  for (int i = 0; i < GameButtons.size(); i++) {
                //      GameButtons.get(i).update(container, game, delta);
                //  }

                break;
        }



    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        switch (state) {
            case STATE_MAINMENU:
                break;
            case STATE_INGAME:
                INGAME_background.draw(1024 - INGAME_width, 0);
                g.drawString("" + GameState.getTimeUntilNextDiceroll(), 950, 745);

                for (int i = 0; i < GameButtons.size(); i++) {
                    GameButtons.get(i).render(container, game, g);
                }

                break;
        }
    }
}
