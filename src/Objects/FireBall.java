


// Source File Name:   FireBall.java

package Objects;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class FireBall extends AnimatedSprite
{

    public FireBall(double x, double y, boolean MoveX, BufferedImage images[], Mario g)
    {
        Gravity = 8;
        XSpeed = -8;
        setLocation(x, y);
        setImages(images);
        setAnimate(true);
        setLoopAnim(true);
        setAnimationTimer(new Timer(100));
        if(MoveX)
            XSpeed = 6;
        else
            XSpeed = -6;
        game = g;
    }

    
    public void update(long l)
    {
        if(Gravity < 8)
            Gravity = Gravity + 1;
        moveY(Gravity);
        moveX(XSpeed);
        if(getY() > 700D)
            setActive(false);
        super.update(l);
    }

    public void bounce()
    {
        Gravity = -8;
    }

    Mario game;
    private int Gravity;
    private int XSpeed;
}
