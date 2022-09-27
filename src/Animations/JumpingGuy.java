


// Source File Name:   JumpingGuy.java

package Animations;

import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.AnimatedSprite;

public class JumpingGuy extends AnimatedSprite
{

    public JumpingGuy(int x, int y, Mario g)
    {
        gravity = -20;
        delay = 0;
        game = g;
        setImages(game.bsLoader.getStoredImages("WhyYouDOThis"));
        setLocation(x, y);
        GroundLevel = y + 64;
    }

    
    public void update(long elapsedTime)
    {
        if(gravity < 20)
            gravity++;
        moveY(gravity / 2);
        if(getY() + (double)height > (double)GroundLevel)
        {
            setY(GroundLevel - 64);
            setFrame(0);
            delay++;
        } else
        {
            setFrame(1);
        }
        if(delay > 10)
        {
            gravity = -20;
            delay = 0;
        }
        super.update(elapsedTime);
    }

    Mario game;
    int gravity;
    int delay;
    int GroundLevel;
}
