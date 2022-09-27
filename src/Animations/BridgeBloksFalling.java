


// Source File Name:   BridgeBloksFalling.java

package Animations;

import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class BridgeBloksFalling extends AnimatedSprite
{

    public BridgeBloksFalling(BufferedImage image[], int i, int i0, int del)
    {
        super(image, i, i0);
        setAnimate(true);
        setAnimationTimer(new Timer(100));
        delay = del;
    }

    
    public void update(long elapsedTime)
    {
        delay--;
        if(delay < 0)
            super.update(elapsedTime);
        if(getFrame() == getFinishAnimationFrame())
            setActive(false);
    }

    int delay;
}
