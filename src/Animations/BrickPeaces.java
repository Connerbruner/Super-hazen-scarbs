


// Source File Name:   BrickPeaces.java

package Animations;

import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class BrickPeaces extends AnimatedSprite
{

    public BrickPeaces(double x, double y, int MoveX, int MoveY, BufferedImage images[])
    {
        Gravity = -5;
        XSpeed = -2;
        setLocation(x + 8D, y + 8D);
        setImages(images);
        setAnimate(true);
        setLoopAnim(true);
        setAnimationTimer(new Timer(200));
        XSpeed = MoveX;
        Gravity = MoveY;
    }

    
    public void update(long l)
    {
        if(Gravity < 10)
            Gravity = Gravity + 1;
        moveY(Gravity);
        moveX(XSpeed);
        if(getY() > 500D)
            setActive(false);
        super.update(l);
    }

    private int Gravity;
    private int XSpeed;
}
