package game;

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
    long last_dice_roll = 0;
    long time_between_roll = 1200;
    int number_of_rolls = 0;
    int last_dice_roll_count = 0;
    long next_roll;
    Map _map;

    @Override
    public int getID() {
        return ID;

    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        this.game = game;
        //Player.getInstance().init(container);

        last_dice_roll = System.currentTimeMillis();
        next_roll = System.currentTimeMillis();

        _map = new Map();
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        game_timer += delta;
        number_of_rolls = (int) (game_timer - (game_timer % 1000)) / 1000;
        if (number_of_rolls > last_dice_roll_count) {
            // Count this as a tick
            System.out.println(game_timer + " : " + number_of_rolls);
            last_dice_roll_count++;
        }


        _map.update(container, game, delta);

        Interface.getInstance().update(container, game, delta);


    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setBackground(Color.gray);

        _map.render(container, game, g);
        Interface.getInstance().render(container, game, g);

        g.setColor(Color.darkGray);
        g.drawString((game_timer) + "", 100, 150);
        g.drawString("" + number_of_rolls, 100, 100);

        //Player.getInstance().render(container, g);


    }
}
