package game;

import effects.particle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {

    /**
     * Create a new test
     */
    public Main() {
        super("Shit son!");
    }

    @Override
    public void initStatesList(GameContainer container) {
        addState(new GameState());
    }

    public static void main(String[] argv) throws FileNotFoundException, SlickException {

        InputStream input = new FileInputStream("resources.xml");
        ResourceManager manager = ResourceManager.getInstance();
        manager.loadResources(input, true);

        try {
            AppGameContainer container = new AppGameContainer(new Main());
            container.setDisplayMode(1024, 800, false);
            container.setSmoothDeltas(true);
            container.setVSync(true);
            container.setShowFPS(true);
            container.start();
        } catch (SlickException e) {
        }
        

    }
}
