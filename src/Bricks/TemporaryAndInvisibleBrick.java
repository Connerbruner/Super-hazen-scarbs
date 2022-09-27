


// Source File Name:   TemporaryAndInvisibleBrick.java

package Bricks;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            BasicBrick

public class TemporaryAndInvisibleBrick extends Sprite
    implements BasicBrick
{

    TemporaryAndInvisibleBrick(int x, int y, BufferedImage storedImage, Mario g)
    {
        Gravity = -5;
        Jump = true;
        delay = 10;
        setLocation(x, y);
        setImage(storedImage);
        game = g;
        setID(2);
    }

    
    public void update(long l)
    {
        delay--;
        if(delay < 0)
            setActive(false);
        if(Gravity >= 4)
        {
            Jump = false;
        } else
        {
            Gravity = Gravity + 1;
            moveY(Gravity);
        }
    }

    
    public void HitFromDown()
    {
    }

    
    public void RemoveIt()
    {
    }

    
    public String getInsideItem()
    {
        return "empty";
    }

    
    public boolean isJump()
    {
        return Jump;
    }

    int Gravity;
    boolean Jump;
    Mario game;
    int delay;
}
