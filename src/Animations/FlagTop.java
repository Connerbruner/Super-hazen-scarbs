


// Source File Name:   FlagTop.java

package Animations;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class FlagTop extends AnimatedSprite
{

    public void ScrollDown()
    {
        ScrollDown = true;
    }

    public FlagTop(BufferedImage image[], double x, double y, Mario g)
    {
        ScrollDown = false;
        delay = 100;
        game = g;
        setImages(image);
        setLocation(x, y);
        setAnimate(true);
        setLoopAnim(true);
        setAnimationTimer(new Timer(150));
        setID(-1);
    }

    
    public void update(long l)
    {
        if(ScrollDown)
        {
            if(getY() > 352D)
            {
                setY(352D);
                IsDown = true;
            }
            if(!IsDown)
                moveY(3D);
        }
        super.update(l);
    }

    private boolean ScrollDown;
    int delay;
    Mario game;
    private boolean IsDown;
}
