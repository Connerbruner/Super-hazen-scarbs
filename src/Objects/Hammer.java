


// Source File Name:   Hammer.java

package Objects;

import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.util.Utility;
import java.awt.image.BufferedImage;

public class Hammer extends AnimatedSprite
{

    Hammer(double x, double y, boolean b, BufferedImage storedImages[])
    {
        PositiveX = true;
        setLocation(x, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(100));
        setAnimate(true);
        setLoopAnim(true);
        setID(1);
        PositiveX = b;
        Gravity = Utility.getRandom(-10, -7);
        Xspeed = Utility.getRandom(2, 4);
        Xspeedinvert = Utility.getRandom(-4, -2);
    }

    Hammer(double x, double y, int Hammerxspeed, int HammerGravity, BufferedImage storedImages[])
    {
        PositiveX = true;
        setLocation(x, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(100));
        setAnimate(true);
        setLoopAnim(true);
        setID(1);
        Gravity = HammerGravity;
        Gravity = Gravity + (double)(Utility.getRandom(-10, 10) / 10);
        Xspeed = Hammerxspeed;
        Xspeed = Xspeed + (double)(Utility.getRandom(-10, 10) / 10);
        PositiveX = false;
    }

    
    public void update(long l)
    {
        if(Gravity < 10D)
            Gravity = Gravity + 0.29999999999999999D;
        moveY(Gravity);
        if(PositiveX)
            moveX(Xspeedinvert);
        else
            moveX(Xspeed);
        if(getY() > 500D)
            setActive(false);
        super.update(l);
    }

    boolean PositiveX;
    double Gravity;
    double Xspeed;
    private double Xspeedinvert;
}
