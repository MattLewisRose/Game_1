package game;

import building.Buildable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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
    
    ArrayList<Buildable> BuildingList = new ArrayList<>();
    
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

        next_roll = System.currentTimeMillis() + time_between_roll;
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        game_timer += delta;
        number_of_rolls = (int) ((int) (game_timer - (game_timer % time_between_roll)) / time_between_roll);
        if (number_of_rolls > last_dice_roll_count) {
            // Count this as a tick
            last_dice_roll_count++;
            next_roll = System.currentTimeMillis() + time_between_roll;
        }


        _map.update(container, game, delta);
        Interface.getInstance().update(container, game, delta);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setBackground(Color.gray);


        _map.render(container, game, g);
        Interface.getInstance().render(container, game, g);

        g.drawString("" + number_of_rolls, 100, 100);
        g.drawString((game_timer) + "", 100, 150);


    }
}
