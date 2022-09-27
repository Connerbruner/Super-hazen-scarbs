


// Source File Name:   Fire.java

package Objects;

import Animations.FireTail;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.util.Utility;
import java.awt.image.BufferedImage;

public class Fire extends AnimatedSprite
{

    public Fire(double x, double y, BufferedImage storedImages[], Mario g)
    {
        setLocation(x, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(100));
        setAnimate(true);
        setLoopAnim(true);
        setID(120);
        actualY = Utility.getRandom(6, 9) * 32;
        game = g;
    }

    
    public void update(long l)
    {
        if(getY() > (double)actualY)
            moveY(-4D);
        if(getY() < (double)actualY)
            moveY(4D);
        moveX(-4D);
        if(getScreenX() < 0.0D)
            setActive(false);
        AddTail();
        if(delay > -10)
            delay--;
        super.update(l);
    }

    private void AddTail()
    {
        if(delay < 0)
        {
            delay = 16;
            game.AnimationGroup.add(new FireTail(getX() + 48D, getY() + 16D, game.bsLoader.getStoredImages("LavaSpots")));
        }
    }

    int actualY;
    private int delay;
    Mario game;
}
