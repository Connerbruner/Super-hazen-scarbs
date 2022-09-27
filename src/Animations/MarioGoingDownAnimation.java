


// Source File Name:   MarioGoingDownAnimation.java

package Animations;

import com.golden.gamedev.object.Sprite;

public class MarioGoingDownAnimation extends Sprite
{

    public MarioGoingDownAnimation()
    {
        delay = 100;
    }

    
    public void update(long l)
    {
        delay--;
        if(delay < 0)
            setActive(false);
        moveY(1.0D);
        super.update(l);
    }

    int delay;
}
