


// Source File Name:   FallingDeadMario.java

package Animations;

import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;

public class FallingDeadMario extends Sprite
{

    public FallingDeadMario(double x, double y, Mario g)
    {
        Gravity = -15;
        delay = 50;
        game = g;
        setLocation(x, y);
        setImage(game.bsLoader.getStoredImage("SmallDeadMario"));
    }

    
    public void update(long l)
    {
        if(delay < 0)
        {
            if(Gravity < 20)
                Gravity = Gravity + 1;
            moveY(Gravity);
        } else
        {
            delay--;
        }
        if(getY() > 700D)
        {
            setActive(false);
            game.Restart();
        }
        super.update(l);
    }

    int Gravity;
    int delay;
    Mario game;
}
