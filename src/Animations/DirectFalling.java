


// Source File Name:   DirectFalling.java

package Animations;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;

public class DirectFalling extends Sprite
{

    public DirectFalling(BufferedImage image, double x, double y, boolean direction)
    {
        Gravity = 5D;
        ToRight = true;
        StraightDown = true;
        setLocation(x, y);
        setImage(ImageUtil.flipVertical(image));
        ToRight = direction;
        StraightDown = false;
    }

    public DirectFalling(BufferedImage image, double x, double y)
    {
        Gravity = 5D;
        ToRight = true;
        StraightDown = true;
        setLocation(x, y);
        setImage(ImageUtil.flipVertical(image));
    }

    public DirectFalling(BufferedImage image, double x, double y, int Gravity)
    {
        this.Gravity = 5D;
        ToRight = true;
        StraightDown = true;
        setLocation(x, y);
        setImage(ImageUtil.flipVertical(image));
        this.Gravity = Gravity;
    }

    public DirectFalling(double x, double y, BufferedImage image)
    {
        this(image, x, y);
    }

    
    public void update(long l)
    {
        if(!StraightDown)
            if(ToRight)
                moveX(4D);
            else
                moveX(-4D);
        if(Gravity < 5D)
            Gravity = Gravity + 0.5D;
        moveY(Gravity);
        if(getY() > 500D)
            setActive(false);
        super.update(l);
    }

    double Gravity;
    boolean ToRight;
    boolean StraightDown;
}
