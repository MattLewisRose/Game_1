package game;

import javax.management.remote.MBeanServerForwarder;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Harry
 */
public class InterfaceMessage {

    String message = "";
    int timeout = 1000;
    float x = (float) (878);
    float y = (float) (800);
    //float ySpeed = (float) (1 + (Math.random() * 2.5));
    float ySpeed = 1.5f;
    long deadTime;
    Color uniqueColour;

    InterfaceMessage(String _message, int _timeout, float _alpha) {
        float r = (float) (0.0 + (Math.random() * 0.6));
        float g = (float) (0.0 + (Math.random() * 0.6));
        float b = (float) (0.0 + (Math.random() * 0.6));
      //  float a = (float) ((_alpha - 0.2) * (Math.random() * 1.8)); 
        float a = 1f;
        
        uniqueColour = new Color(r, g, b, a);
        message = _message;
        timeout = _timeout * 1000;
        deadTime = System.currentTimeMillis() + timeout;
    }

    public void init(GameContainer container) throws SlickException {
    }

    public void update(GameContainer container, int delta) throws SlickException {
        // Input input = container.getInput();
        y -= ySpeed;
    }

    public void render(GameContainer container, Graphics g) throws SlickException {
        //g.setFont(GameUI.uniFont);
        g.setColor(uniqueColour);
        g.drawString(message, x, y);
    }
}
