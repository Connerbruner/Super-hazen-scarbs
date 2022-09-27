


// Source File Name:   LavaSpots.java

package Animations;

import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.VolatileSprite;
import java.awt.image.BufferedImage;

public class LavaSpots extends VolatileSprite
{

    public LavaSpots(double x, double y, BufferedImage storedImages[])
    {
        super(storedImages, x, y);
        setAnimationTimer(new Timer(200));
    }

    
    public void update(long elapsedTime)
    {
        moveY(-1D);
        super.update(elapsedTime);
    }
}
