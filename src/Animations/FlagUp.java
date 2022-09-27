


// Source File Name:   FlagUp.java

package Animations;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class FlagUp extends AnimatedSprite
{

    public FlagUp(BufferedImage storedImages[], int x, int y)
    {
        setLocation(x, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(140));
        setAnimate(true);
        setLoopAnim(true);
        ogrignalY = y - 64;
    }

    
    public void update(long elapsedTime)
    {
        if(getY() > (double)ogrignalY)
            moveY(-3D);
        super.update(elapsedTime);
    }

    int ogrignalY;
    Mario game;
}
