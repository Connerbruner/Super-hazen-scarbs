


// Source File Name:   FireTail.java

package Animations;

import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.VolatileSprite;
import java.awt.image.BufferedImage;

public class FireTail extends VolatileSprite
{

    public FireTail(double x, double y, BufferedImage storedImages[])
    {
        super(storedImages, x, y);
        setAnimationTimer(new Timer(100));
    }

    
    public void update(long elapsedTime)
    {
        moveY(2D);
        super.update(elapsedTime);
    }
}
