


// Source File Name:   Dust.java

package Animations;

import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.VolatileSprite;
import java.awt.image.BufferedImage;

public class Dust extends VolatileSprite
{

    public Dust(double x, double y, BufferedImage storedImages[])
    {
        super(storedImages, x, y);
        setActive(true);
        setAnimationTimer(new Timer(100));
    }
}
