package game;

import building.Buildable;
import java.awt.GradientPaint;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lighting.Light;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {

    public static final int ID = 1;
    private StateBasedGame game;
    long game_timer = 0;
    long time_between_roll = 5000;
    static long next_roll;
    int number_of_rolls = 0;
    int last_dice_roll_count = 0;
    Map _map;
    int resources = 150;
    lighting.LightManager LightManager;
    ArrayList<Light> lights = new ArrayList<>();
    //private Color sharedColor = new Color(1f, 1f, 1f, 1f);
    ArrayList<Buildable> BuildingList = new ArrayList<>();
    Interface game_interface;

    //building.Buildable a = new building.Barracks(building.Buildable.BUILDING_BARRACKS, 50, 50);
    @Override
    public int getID() {
        return ID;
    }

    public static int getTimeUntilNextDiceroll() {
        long time_until_tick = next_roll - System.currentTimeMillis();
        return (int) (time_until_tick / 1000) + 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.game = game;
        _map = new Map();

        LightManager = new lighting.LightManager(_map.getMap());

        next_roll = System.currentTimeMillis() + time_between_roll;

        lights.add(new lighting.Light(400, 400, 0.8f, 3f, 1f));
        lights.add(new lighting.Light(0, 0, 0.8f, 3f, 1f));

        game_interface = new Interface();

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        Input input = container.getInput();


        game_timer += delta;
        number_of_rolls = (int) ((int) (game_timer - (game_timer % time_between_roll)) / time_between_roll);
        if (number_of_rolls > last_dice_roll_count) {
            // Count this as a tick
            last_dice_roll_count++;
            next_roll = System.currentTimeMillis() + time_between_roll;
        }

        lights.get(0).setLocation(input.getMouseX(), input.getMouseY());

        for (int i = 0; i < lights.size(); i++) {
            if (i == 0) {
                lights.get(i).setLocation(input.getMouseX(), input.getMouseY());
            } else {
            }
        }


        _map.update(container, game, delta);

        game_interface.update(container, game, delta);

        LightManager.update(container, game, delta, lights);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setBackground(Color.gray);


        _map.render(container, game, g);

        LightManager.render(container, g);

        game_interface.render(container, game, g);


    }
    /*
     @Override
     public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {


     for (int i = 0; i < lights.size(); i++) {
     Light light = lights.get(i);

     g.setDrawMode(Graphics.MODE_ALPHA_MAP);
     //g.clearAlphaMap();

     int alphaW = (int) (alphaMap.getWidth() * light.scale);
     int alphaH = (int) (alphaMap.getHeight() * light.scale);
     int alphaX = (int) (light.x - alphaW / 2f);
     int alphaY = (int) (light.y - alphaH / 2f);

     alphaMap.draw(alphaX, alphaY, alphaW, alphaH);

     g.setDrawMode(Graphics.MODE_ALPHA_BLEND);

     //we'll clip to the alpha rectangle, since anything outside of it will be transparent
     g.setClip(alphaX, alphaY, alphaW, alphaH);
     light.getTint().bind();

     // Draw goes here
     _map.render(container, game, g);


     g.clearClip();
     }

     //reset the mode to normal before continuing..

     g.setDrawMode(Graphics.MODE_NORMAL);


     Interface.getInstance().render(container, game, g);

     g.setColor(Color.white);
     g.drawString("(" + lights.size() + ")", 10, 25);

     }*/
    
    public void addBuilding(building.Buildable building) {
        BuildingList.add(building);
    }
    
}
