


// Source File Name:   MarioGoingInPump.java

package Animations;

import com.golden.gamedev.object.AnimatedSprite;

public class MarioGoingInPump extends AnimatedSprite
{

    public MarioGoingInPump()
    {
        delay = 70;
    }

    
    public void update(long l)
    {
        delay--;
        if(delay < 0)
            setActive(false);
        moveX(1.0D);
        super.update(l);
    }

    int delay;
}
