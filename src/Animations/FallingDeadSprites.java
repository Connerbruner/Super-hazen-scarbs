


// Source File Name:   FallingDeadSprites.java

package Animations;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;

public class FallingDeadSprites extends Sprite
{

    public FallingDeadSprites(double x, double y, BufferedImage image, boolean direction)
    {
        Gravity = -15;
        delay = 0;
        ToRight = true;
        StraightFall = false;
        ToRight = direction;
        setLocation(x, y);
        setImage(ImageUtil.flipVertical(image));
    }

    public FallingDeadSprites(double x, double y, BufferedImage storedImage, int i, String straight)
    {
        this(x, y, storedImage, true);
        delay = i;
        Gravity = -20;
        if("StraightFalling".equals(straight))
            StraightFall = true;
    }

    
    public void update(long l)
    {
        if(!StraightFall)
            if(ToRight)
                moveX(-4D);
            else
                moveX(4D);
        if(delay < 0)
        {
            if(Gravity < 20)
                Gravity = Gravity + 1;
            moveY(Gravity);
        } else
        {
            delay--;
        }
        if(getY() > 700D)
            setActive(false);
        super.update(l);
    }

    int Gravity;
    int delay;
    boolean ToRight;
    boolean StraightFall;
}
