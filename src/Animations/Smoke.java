


// Source File Name:   Smoke.java

package Animations;

import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.VolatileSprite;
import java.awt.image.BufferedImage;

public class Smoke extends VolatileSprite
{

    public Smoke(double x, double y, BufferedImage storedImages[])
    {
        super(storedImages, x, y);
        setActive(true);
        setAnimationTimer(new Timer(160));
    }
}
